pipeline{
	agent any
    environment {
        SECRET_TOKEN = credentials('secret-token')
    }
	stages {
		stage('Start Grid'){
			steps {
				bat 'docker-compose up -d hub chrome firefox'
			}
		}
		stage('Run Test'){
			steps{
				bat 'mvn clean test -DBROWSER=firefox -Dcucumber.options="--tags @login"'
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
           emailext (to: 'magrand073@gmail.com', replyTo: 'magrand073@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: "http://localhost:8080/job/Runner/${env.BUILD_NUMBER}/allure/", mimeType: 'text/html');
			bat 'docker-compose down'
		}
	}
}
