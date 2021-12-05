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
				bat 'mvn clean test -Dcucumber.options="--tags @login"'
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
			var emailBody = '${SCRIPT, template="regressionfailed.groovy"}'
            emailext (to: 'magrand073@gmail.com', replyTo: 'magrand073@gmail.com', subject: "[Jenkins] Test Execution Summary' ", body: ${SCRIPT, template="allure-report.groovy"}, mimeType: 'text/html');
			bat 'docker-compose down'
		}
	}
}
