node('unix-slave'){

  stage('SCM Checkout'){
  
    git 'https://github.com/santoshkamat11/TicketManagementGithub'
  
  }
  
  stage('Compile-Package'){
  
    sh 'mvn clean install'
  
  }
  
  
}
