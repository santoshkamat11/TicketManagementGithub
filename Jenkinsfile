node('linux-latest-slave'){
  
  stage('SCM Checkout'){

    git 'https://github.com/santoshkamat11/TicketManagementGithub'

  }

  stage('Compile-Package'){

    sh 'mvn clean install'

  }
  
  stage('Push the image'){

    sh 'docker login -u santoshkamat11 -p police12@'
    sh 'docker push santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
    echo 'Image pushed to the repository successfully'
    sh 'docker rmi -f santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
    echo 'image removed successfully'

  }
  
  stage('Kubernetes'){
  
    sshagent ( ['jenkins-kubernetes-user']){
      
      sh 'scp -o StrictHostKeyChecking=no services.yml pods.yml jenkins-kubernetes-user@35.198.223.144:/home/jenkins-kubernetes-user/'
    
      script{
      
        try{
            sh 'jenkins-kubernetes-user@35.198.223.144 kubectl apply -f .'
        }
        catch{
            sh 'jenkins-kubernetes-user@35.198.223.144 kubectl create -f .'
        }
        
      }
    }
  
  }

  

  
  
}
