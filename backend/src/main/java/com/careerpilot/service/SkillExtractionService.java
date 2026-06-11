package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SkillExtractionService {

    private static final List<String> SKILLS = List.of(

        // Programming Languages
        "Java",
        "Python",
        "JavaScript",
        "TypeScript",
        "C",
        "C++",
        "C#",
        "Go",
        "Rust",
        "Kotlin",
        "Swift",
        "PHP",
        "Ruby",
        "Scala",
        "R",
        "Dart",

        // Backend
        "Spring",
        "Spring Boot",
        "Hibernate",
        "JPA",
        "Microservices",
        "REST API",
        "GraphQL",
        "Node.js",
        "Express.js",
        "NestJS",
        "ASP.NET",
        "Django",
        "Flask",
        "FastAPI",
        "Laravel",

        // Frontend
        "HTML",
        "CSS",
        "Bootstrap",
        "Tailwind CSS",
        "Material UI",
        "React",
        "Next.js",
        "Angular",
        "Vue.js",
        "Redux",
        "React Query",
        "jQuery",
        "SASS",

        // Databases
        "SQL",
        "MySQL",
        "PostgreSQL",
        "MongoDB",
        "Redis",
        "Oracle",
        "SQLite",
        "Cassandra",
        "DynamoDB",
        "Elasticsearch",
        "Firebase",

        // Cloud
        "AWS",
        "Azure",
        "GCP",
        "Cloud Computing",

        // AWS Services
        "EC2",
        "S3",
        "Lambda",
        "RDS",
        "CloudWatch",
        "IAM",
        "ECS",
        "EKS",
        "Route53",
        "SNS",
        "SQS",

        // DevOps
        "Docker",
        "Kubernetes",
        "Jenkins",
        "GitLab CI/CD",
        "GitHub Actions",
        "Terraform",
        "Ansible",
        "Helm",
        "ArgoCD",
        "CI/CD",

        // Version Control
        "Git",
        "GitHub",
        "GitLab",
        "Bitbucket",

        // Testing
        "JUnit",
        "Mockito",
        "TestNG",
        "Jest",
        "Mocha",
        "Cypress",
        "Selenium",
        "Playwright",
        "Postman",
        "REST Assured",

        // Architecture
        "System Design",
        "Design Patterns",
        "Clean Architecture",
        "Hexagonal Architecture",
        "Event Driven Architecture",
        "Domain Driven Design",
        "DDD",
        "CQRS",

        // Data Engineering
        "Apache Spark",
        "Hadoop",
        "Kafka",
        "Airflow",
        "Databricks",
        "Snowflake",
        "ETL",
        "Data Warehousing",
        "BigQuery",

        // AI / ML
        "Artificial Intelligence",
        "Machine Learning",
        "Deep Learning",
        "Generative AI",
        "LLM",
        "Large Language Models",
        "Prompt Engineering",
        "Fine Tuning",
        "RAG",
        "LangChain",
        "LangGraph",
        "Vector Database",
        "Embeddings",
        "MLOps",

        // ML Frameworks
        "TensorFlow",
        "PyTorch",
        "Scikit-learn",
        "XGBoost",
        "LightGBM",
        "Keras",
        "Hugging Face",

        // AI Domains
        "Natural Language Processing",
        "NLP",
        "Computer Vision",
        "Speech Recognition",
        "Recommendation Systems",
        "Time Series Forecasting",

        // Data Science
        "Data Science",
        "Statistics",
        "Predictive Modeling",
        "Feature Engineering",
        "Data Analysis",
        "Data Visualization",
        "A/B Testing",

        // Python Ecosystem
        "NumPy",
        "Pandas",
        "Matplotlib",
        "Seaborn",
        "SciPy",

        // Mobile Development
        "Android",
        "iOS",
        "Flutter",
        "React Native",

        // Security
        "Cybersecurity",
        "OAuth",
        "JWT",
        "Authentication",
        "Authorization",
        "OWASP",

        // Messaging
        "RabbitMQ",
        "ActiveMQ",

        // Monitoring
        "Prometheus",
        "Grafana",
        "ELK Stack",
        "Splunk",

        // Agile
        "Agile",
        "Scrum",
        "Kanban",
        "Jira",

        // Soft Skills
        "Leadership",
        "Communication",
        "Problem Solving",
        "Teamwork",
        "Mentoring",
        "Stakeholder Management",

        // Full Stack
        "Frontend",
        "Backend",
        "Full Stack",
        "Web Development",
        "Software Development",

        // ATS Keywords
        "Scalable Systems",
        "Distributed Systems",
        "High Availability",
        "Performance Optimization",
        "API Development",
        "Cloud Native",
        "Containerization",
        "Automation",
        "Workflow Orchestration"
    );

    public List<String> extractSkills(String text) {

        List<String> detectedSkills = new ArrayList<>();

        if (text == null || text.isBlank()) {
            return detectedSkills;
        }

        String lowerText = text.toLowerCase();

        for (String skill : SKILLS) {

            if (lowerText.contains(skill.toLowerCase())) {
                detectedSkills.add(skill);
            }
        }

        return detectedSkills;
    }
}