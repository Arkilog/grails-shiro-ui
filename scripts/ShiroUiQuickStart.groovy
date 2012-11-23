includeTargets << grailsScript("_GrailsInit")

target(main: "Installs shiro domain classes, controllers, DB realm and plugin views") {
	ant.copy(todir: "grails-app/domain/") {
		fileset(dir: "${shiroUiPluginDir}/grails-app/domain/")
	}
	ant.copy(todir: "grails-app/controllers/") {
		fileset(dir: "${shiroUiPluginDir}/grails-app/controllers/")
	}
	ant.copy(todir: "grails-app/realms/") {
		fileset(dir: "${shiroUiPluginDir}/grails-app/realms/")
	}
	ant.copy(todir: "grails-app/views/") {
		fileset(dir: "${shiroUiPluginDir}/grails-app/views/"){
			exclude(name:'**/error.gsp')
			exclude(name:'**/main.gsp')
		}
	}
}

setDefaultTarget(main)
