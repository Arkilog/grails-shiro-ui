//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//
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
