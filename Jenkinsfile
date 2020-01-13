node('unix-slave'){

  
  
  stage('Pull the image'){
  
    sh -t 'sudo docker pull santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
    sh -t 'sudo docker run -p 7070:8080 santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
  
  }
  
  
}
