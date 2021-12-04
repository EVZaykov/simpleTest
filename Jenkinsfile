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
		stage('Create report'){
			steps{
				script {
					allure([
						includeProperties: false,
						jdk: '',
						properties: [],
						reportBuildPolicy: 'ALWAYS',
						results: [[path: 'target/allure-results']]
					])
				}
			}
		}
		stage('Send Email'){
		steps{
			emailext (
				subject: email_subject,
				mimetype: 'text/html',
				to: 'evzaykov@bk.ru',
				recipientProviders: [[$class: 'CulpritsRecipientProvider'],[$class: 'RequesterRecipientProvider']],
				body: email_body
			)
		}
	}
	}
	post{
		always{
			emailext
			bat 'docker-compose down'
		}
	}
}
