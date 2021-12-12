pipeline{
	agent any
    environment {
        SECRET_TOKEN = credentials('secret-token')
    }
	stages {
		stage('Start Grid'){
			steps {
				print "DE2312BUG: parameter foo = ${BROWSER}"
				bat "docker-compose up -d selenium-hub && docker-compose scale ${BROWSER}=3"
			}
		}
		stage('Run Test'){
			steps{
				bat "mvn clean test "-Dwebdriver.browser.name=${BROWSER}" "-Dcucumber.options=--tags @qwert12 ""
			}
		}
	}
	post{
		always{
			script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
              ])
            }
           emailext (to: 'magrand073@gmail.com', replyTo: 'magrand073@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: "${env.BROWSER} <br> http://localhost:8080/job/Runner/${env.BUILD_NUMBER}/allure/ <br> http://localhost:8080/job/Runner/${env.BUILD_NUMBER}/", mimeType: 'text/html');
			bat 'docker-compose down'
		}
	}
}
