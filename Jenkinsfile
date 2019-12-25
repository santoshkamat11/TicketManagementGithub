node{

  stage('SCM Checkout'){
  
    git 'https://github.com/santoshkamat11/TicketManagementGithub'
  
  }
  
  stage('Compile-Package'){
  
    bat 'mvn package'
  
  }
  
  stage(Email-Notification){
  
    mail bcc: '', body: 'Hi. Welcome to jenkins', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'pranavkamat11@gmail.com'
  }
}
