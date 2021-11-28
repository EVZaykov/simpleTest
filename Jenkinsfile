pipeline{
	agent any
	stages {
		stage('Start Grid'){
			steps {
				sh 'docker-compose up -d hub chrome firefox'
			}
		}
		stage('Run Test'){
			steps{
				sh 'mvn test -DBROWSER=firefox'
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
