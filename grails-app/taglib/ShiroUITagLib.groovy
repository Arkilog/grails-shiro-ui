import org.apache.shiro.SecurityUtils

class ShiroUITagLib{
    static namespace = "shiroui"
	
	def permissionSelect = {attrs->
		def allPerms =  ((attrs.value ?: []) + grailsApplication.controllerClasses.findAll{it.propertyName!="authController"}.collect{controller->
			def base = controller.propertyName - 'Controller';
			controller.getURIs().collect{def action = it.split('\\/')
			action  = (action.size() == 2 ? "*" : action[2] )
			"${base}:${action}"}
		}+ "*:*").flatten().collect{it.toString()}.unique().sort()
		if (allPerms) {
		out << g.select(name:attrs.name, from:allPerms, multiple:true, size:(attrs.size ?: 10), value:(attrs.value ?: []), noSelection:['':''], 'class':"many-to-many")
		} else {
		out << "<i>-</i>"
		}
	}

	def userSelect = {attrs->
		def allUsers = ShiroUser.list()
		if (!grailsApplication.config.shiroui.manage.current.session.user){
			allUsers -= ShiroUser.findByUsername(SecurityUtils.subject?.principal)
		}
		if (allUsers) {
			out << g.select(name:attrs.name, optionKey:'id', from:allUsers, multiple:true, size:(attrs.size ?: 10), value:(attrs.value ?: []), noSelection:['':''], 'class':"many-to-many")
		} else {
			out << "<i>-</i>"
		}
	}

	def roleSelect = {attrs->
		def allRoles = ShiroRole.list()
		if (allRoles) {
		out << g.select(name:attrs.name, optionKey:'id', from:allRoles, multiple:true, size:(attrs.size ?: 10), value:(attrs.value ?: []), noSelection:['':''], 'class':"many-to-many")
		} else {
			out << "<i>-</i>"
		}
	}

}