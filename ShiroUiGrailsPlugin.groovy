class ShiroUiGrailsPlugin {
    // the plugin version
    def version = "1.0-beta4"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3 > *"
    // the other plugins this plugin depends on
    def dependsOn = [shiro:'1.1.3 > *', mail: '1.0-SNAPSHOT > *']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Yellowsnow"
    def authorEmail = ""
    def title = "A basic Shiro User Interface"
    def description = '''\\
This plugin tries to provide a basic user interface for shiro plugin.

It provides the following features :
 * User and Role management frontends with basic permission configuration
 * Password recovery via email
 * Password update
 * Default admin user
 
RoadMap
 * User sign-up
 * Allow custom permissions such as "book:buy,sell:1,2"
 * Email templates
 
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/shiro-ui"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
