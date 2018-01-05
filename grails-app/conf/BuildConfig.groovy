/**if(System.getenv('TRAVIS_BRANCH')) {
    grails.project.repos.grailsCentral.username = System.getenv("GRAILS_CENTRAL_USERNAME")
    grails.project.repos.grailsCentral.password = System.getenv("GRAILS_CENTRAL_PASSWORD")    
}**/

grails.work.dir="target"

coverage {
    xml = true
}

codenarc.reports = {
    DemoApplicationXmlReport('xml') {
        outputFile = 'target/CodeNarcReport.xml'
        title = 'Grails CML plugin Codenarc Report'
    }
    DemoApplicationHtmlReport('html') {
        outputFile = 'target/CodeNarcReport.html'
        title = 'Grails CML plugin Codenarc Report'
    }
}


grails.project.target.level = 1.8
grails.project.source.level = 1.8

//grails.project.dependency.resolver='maven'
grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    /**repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }**/

    dependencies {
        build('org.grails:grails-gdoc-engine:1.0.1') {
            export = false
        }

        test("org.spockframework:spock-grails-support:0.7-groovy-2.0") {
            export = false
        }
    }

    plugins {
        build ':release:3.0.1', ':rest-client-builder:2.0.1', {
            export = false
        }
        build('com.jcatalog.grailsplugins:build-process:7.16.GA.1',
              ':codenarc:0.19')

        runtime(":resources:1.2.8") {
            export = false
        }

        test(":hibernate:3.6.10.14") {
            export = false
        }

    }
}
