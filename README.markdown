This plugin tries to provide a basic user interface for shiro plugin. It depends on the excellent shiro and mail plugins.

*IMPORTANT NOTE :* The ShiroDBRealm is used in this plugin.

*Installation* 

```grails install-plugin http://cloud.github.com/downloads/yellowsnow/Grails-Shiro-UI/grails-shiro-ui-1.0-beta2.zip```

It provides the following features :

* User and Role management frontends with basic permission configuration : ${appName}/shiroUser/ and ${appName}/shiroRole/ 
* Password recovery via email : ${appName}/auth/lostPassword
* Password update : ${appName}/auth/updatePassword
* User creation by priviliged user with temporary password sent by email (password update is requested on log on)

During installation, all templates (controllers, domain classes and views) are directly copied to the project.

*Admin user creation*

Admin user creation can be done in the Bootstrap :

```groovy
import org.apache.shiro.crypto.hash.Sha256Hash

class BootStrap {
    def init = { servletContext ->
		def adminRole = ShiroRole.findByName("Administrator")
		if(!adminRole){
		  adminRole = new ShiroRole(name: 'Administrator')
		  adminRole.save()
		}
		def admin = ShiroUser.findByUsername('admin')
		if(!admin){
		  admin = new ShiroUser(firstName:"Administator",lastName:"User", 
username: 'admin', passwordHash: new Sha256Hash("changeit").toHex(),email:'someone@gmail.com')
		  admin.save()
		  adminRole.addToUsers(admin)
		  adminRole.save()
		  admin.addToPermissions("*:*")
		}
    }
    def destroy = {
    }
}
```

*Plugin RoadMap*

* Allow custom permissions such as "book:buy,sell:1,2"
* External mail templates (now hardcoded in controller)
* Script to manually install templates
* User sign-up with admin approval
* Better documentation