pipeline{
    agent any
    
    stages{
        stage("Confirm Checkout"){
            steps{
                bat "dir"
                bat "echo Source Code Checkout Successful"
            }
        }
        stage("Run Tests"){
            steps{
                bat "echo Running tests for TestApp"
                bat """
                    cd TestApp
                    mvn test
                """
            }
        }
        stage("Validate Project Structure"){
            steps{
                bat "echo Validating Project structure"
                bat """
                    cd TestApp
                    mvn validate
                """
            }
        }
        stage("Source code build"){
            steps{
                bat "echo Building source code for TestApp"
                bat """
                    cd TestApp
                    mvn clean install
                """
            }
        }
        stage("Deploy to Server"){
            input{
                message "Do you want to deploy the app to server"
                ok "yes"
            }
            steps{
                bat "ping 127.0.0.1 -n 20 > nul"
                bat "echo Project deployed to Server"
            }
        }
        stage("Run the app"){
            options {
                timeout(time: 3, unit: 'MINUTES')
            }
            steps{
                bat "echo Running TestApp"
                bat """
                    cd TestApp/target
                    java -jar TestApp-0.0.1-SNAPSHOT.jar
                """
            }
        }
    }
    post{
        always{
            cleanWs();
            bat "echo Workspace cleaned up"
        }
    }
}
