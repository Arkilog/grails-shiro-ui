This plugin tries to provide a basic user interface for shiro plugin. It depends on the excellent shiro and mail plugins.

*IMPORTANT NOTE :* The ShiroDBRealm is used in this plugin, which means users are managed in your database.

*Installation* 

```grails install-plugin http://cloud.github.com/downloads/Arkilog/grails-shiro-ui/grails-shiro-ui-1.2.0-SNAPSHOT.zip```

*Quick Start* 

Installs shiro domain classes, controllers, DB realm and plugin views :

```grails shiro-ui-quick-start```

*Feature summary*

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
    def grailsApplication
    def init = { servletContext ->
      //This code is only for demo purposes
        def adminRole = ShiroRole.findByName("Administrator")
        if(!adminRole){
          adminRole = new ShiroRole(name: 'Administrator')
          adminRole.save(failOnError:true)
        }
        def admin = ShiroUser.findByUsername('admin')
        if(!admin){
          def hash = new Sha256Hash("changeit").toHex()
          admin = new ShiroUser(firstName:"Administator",lastName:"User", 
username: 'admin', email:"me@the.internet")
          admin.passwordHash = hash
          admin.save(failOnError:true)
          adminRole.addToUsers(admin)
          adminRole.save(failOnError:true)
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
* User sign-up with admin approval
* Better documentation

*License*

Licensed under the Apache License, Version 2.0.

*Contributing*

Contributions are welcome : comments, ideas, issues and of course pull requests.