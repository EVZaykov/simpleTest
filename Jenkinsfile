pipeline{
	agent any
	stages {
		stage('Start Grid'){
			steps {
				bat 'docker-compose up -d hub chrome firefox'
			}
		}
		stage('Run Test'){
			steps{
				bat 'mvn test -DBROWSER=firefox -Dcucumber.options="--tags @helloWorld1"'
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
			emailext ''', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "evzaykov@bk.ru";'
			bat 'docker-compose down'
		}
	}
}
