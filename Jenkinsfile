node('unix-slave'){

  
  
  stage('Pull the image'){
  
    sh -S 'docker pull santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
    sh -S 'docker run -p 7070:8080 santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
  
  }
  
  
}
