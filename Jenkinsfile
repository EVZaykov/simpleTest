pipeline{
	agent any
    environment {
        SECRET_TOKEN = credentials('secret-token')
    }
	stages {
		stage('Start Grid'){
			steps {
				sh 'docker-compose up -d hub chrome firefox'
			}
		}
		stage('Run Test'){
			steps{
				sh 'mvn clean test -DBROWSER=firefox -Dcucumber.options="--tags @inWork"'
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
			sh 'docker-compose down'
		}
	}
}
