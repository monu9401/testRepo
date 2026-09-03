pipeline{
    agent any
    
    environment{
        technology="Java"
    }
    
    parameters{
        string(name:"Username")
        booleanParam(name:"Confirm your username")
        choice(name:"Select environment", choices:["DEV","UAT","PROD"])
    }
    
    stages{
        stage("Run some commands"){
            steps{
                bat "echo Let's run some commands"
                bat "dir"
                bat "whoami"
            }
        }
        stage("View environment variables"){
            environment{
                year="2026"
            }
            steps{
                bat "echo Some environment variables"
                bat "echo %BUILD_ID%"
                bat "echo %BUILD_NUMBER%"
                bat "echo %technology%"
                bat "echo %year%"
                bat "echo %admin_user%"
            }
        }
        stage("View input parameters"){
            steps{
                bat "echo %Username%"
                bat "echo %Confirm your username%"
                bat "echo %Select environment%"
            }
        }
        stage("Checkout from Git"){
            steps{
                bat "echo Cloning from Git"
                bat "git clone https://github.com/monu9401/testRepo.git"
                bat "dir"
            }
        }
        stage("Deploy to Production"){
            input{
                message "Should we deploy to Production"
                ok "Yes"
            }
            steps{
                bat "echo Deploying to Production"
            }
        }
        stage("Cleanup workspace"){
            steps{
                bat "rmdir /s /q testRepo"
                bat "echo Workspace cleaned up"
                bat "dir"
            }
        }
    }
    post{
        always{
            cleanWs()
            bat "echo Workspace cleaned up"
        }
        failure{
            bat "echo Some failure encountered. Please check logs"
        }
        success{
            bat "echo Everything worked well"
        }
    }
}
