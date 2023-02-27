pipeline{
	agent any
    environment {
        SECRET_TOKEN = credentials('secret-token')
	CUCUMBER_TAG = "--tags ${TAGS}"
    }
	stages {
		stage('Start Grid'){
			steps {
				bat "docker-compose up -d selenium-hub && docker-compose scale ${BROWSER}=3"
			}
		}
		stage('Run Test'){
			steps{
				bat "mvn clean test -Dwebdriver.browser.name=${BROWSER} -Dcucumber.options=\"${CUCUMBER_TAG}\""
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
			//emailext (to:  "${Email}", replyTo: "", subject: "Email Report from - '${env.JOB_NAME}' ", body: "${env.BROWSER} <br> http://localhost:8080/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/allure/ <br> http://localhost:8080/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/", mimeType: 'text/html');
			bat 'docker-compose down'
		}
	}
}
