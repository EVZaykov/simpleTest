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
				bat
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
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
			bat 'docker-compose down'
		}
	}
}
