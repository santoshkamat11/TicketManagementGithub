node('unix-slave'){

  
  
  stage('Pull the image'){
  
    sh 'docker pull santoshkamat11/ticket-booking:0.0.1-SNAPSHOT'
    sh 'docker run -p 7070:8080 santoshkamat11/ticket-booking:0.0.1-SNAPSHOT'
    echo "Application started on port 8080. You can access on port 7070"
  
  }
  
  
}
