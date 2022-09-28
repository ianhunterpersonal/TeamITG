pipeline {

	environment {
		imagename = "ianhunterpersonal/teamitg"
		registryCredential = 'dockerhub'
		dockerImage = ''
	}

    agent any
    stages {
    
        stage('Clean') { 
            steps { 
               sh 'mvn clean'
            }
        }
        stage('Compile') { 
            steps { 
               sh 'mvn compile'
            }
        }
        stage('Test') { 
            steps { 
               sh 'mvn test'
            }
        }
        stage('Package') { 
            steps { 
               sh 'mvn package'
            }
        }

        stage('Building image') {
			  steps {
			   sh 'echo "Building image...."'
				script {
					dockerImage = docker.build imagename
					echo "${dockerImage}"
				}
			 }
		  }
		  
	    stage('Deploy Image') {
	      steps{
	        script {
	          docker.withRegistry( '', registryCredential ) {
	            dockerImage.push("$BUILD_NUMBER")
	            dockerImage.push('latest')
	          }
	        }
	      }
	    }
	    
	    stage('Remove Unused docker image') {
	      steps {
	         sh "docker rmi $imagename:$BUILD_NUMBER"
	         sh "docker rmi $imagename:latest"
	      }
	    }        
	}
}
