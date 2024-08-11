# food-delivery-app

# End-to-End Application Deployment with Microservices, Docker, Kubernetes, Jenkins, and AWS

## Overview
This project is a comprehensive implementation of a modern, scalable microservices-based application. The project is designed to demonstrate the complete lifecycle of application development and deployment using industry-standard tools and technologies.

## Technologies Used
- **Microservices**: Modular, scalable, and decoupled application architecture.
- **Angular**: Frontend framework for building dynamic and responsive web applications.
- **JUnit**: Testing framework to ensure code reliability.
- **SonarQube**: Code quality analysis tool to maintain high standards of code quality.
- **Docker**: Containerization tool to package applications with all dependencies.
- **Kubernetes (K8s)**: Container orchestration tool for managing containerized applications at scale.
- **AWS (Amazon Web Services)**: Cloud platform for deploying applications.
- **AWS EKS (Elastic Kubernetes Service)**: Managed Kubernetes service on AWS.
- **AWS Load Balancer**: Distributes incoming application traffic across multiple targets, enhancing application scalability.
- **AWS RDS (Relational Database Service)**: Managed relational database service for cloud applications.
- **MongoDB Atlas**: Cloud-based NoSQL database service.
- **Jenkins**: Continuous integration and deployment tool for automating the build and deployment process.
- **CI/CD (Continuous Integration/Continuous Deployment)**: Software development practice that automates testing and delivery of code changes.
- **ArgoCD**: Declarative continuous delivery tool for Kubernetes.

## Project Structure
- **Frontend**: Developed using Angular.
- **Backend**: Microservices architecture using Docker for containerization.
- **Database**: Combination of SQL (AWS RDS) and NoSQL (MongoDB Atlas).
- **CI/CD Pipeline**: Implemented using Jenkins and ArgoCD.
- **Container Orchestration**: Managed with Kubernetes and AWS EKS.

## Features
- **Modular Microservices Architecture**: Allows for scalability and easy maintenance.
- **Responsive Frontend**: Built using Angular for dynamic and user-friendly interactions.
- **Containerization**: Both backend and frontend are Dockerized for consistency across environments.
- **Orchestration with Kubernetes**: Efficiently manage containerized applications at scale.
- **Automated Deployment Pipeline**: CI/CD pipeline with Jenkins and ArgoCD ensures reliable and consistent application releases.
- **Cloud Deployment**: Fully deployed on AWS using EKS and RDS for backend and MongoDB Atlas for data management.

## Getting Started
### Prerequisites
- Docker installed
- Kubernetes cluster (local or cloud-based)
- AWS account
- Jenkins installed
- MongoDB Atlas account

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/your-repo.git

2. **Navigate to the project directory**:
    ```bash
    cd your-repo

3. **Build and run Docker containers**:
    ```bash
    docker-compose up --build

4. **Deploy to Kubernetes**:
- Set up your Kubernetes cluster.
- Use the provided Kubernetes YAML files to deploy the application.

5. **Set up CI/CD pipeline**:
- Configure Jenkins with the provided Jenkinsfile.
- Set up ArgoCD for continuous delivery.

6. **Deploy to AWS**:
- Create an EKS cluster using AWS CLI or AWS Management Console.
- Deploy the application to the EKS cluster.
- Set up AWS RDS for the backend database and MongoDB Atlas for NoSQL data.