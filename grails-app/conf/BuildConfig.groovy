grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        build('org.grails:grails-gdoc-engine:1.0.1') {
            export = false
        }
    }

    plugins {
        build(':release:3.0.1') {
            export = false
        }

        runtime(":resources:1.2.14") {
            export = false
        }

        compile(":hibernate:3.6.10.18"){
            export = false
        }
    }
}
