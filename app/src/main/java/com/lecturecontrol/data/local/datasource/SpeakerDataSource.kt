package com.lecturecontrol.data.local.datasource

import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.domain.model.Speaker

class SpeakerDataSource {
    private val speakers = mutableListOf(
        Speaker(
            id = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
            shortName = "Carlos Santos",
            fullName = "Carlos Santos Silva Junior",
            imageUrl = "https://media.npr.org/assets/img/2022/11/08/ap22312071681283-0d9c328f69a7c7f15320e8750d6ea447532dff66-s1100-c50.jpg",
            company = "Company Abcde",
            title = "Desenvolvedor Java",
            companyImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9nS21qlQQmvlrWPL4kEixfNWurjN0vY1tvQ&usqp=CAU",
            biography = "Carlos Santos é um desenvolvedor Java Sênior com 10 anos de experiência, formado em Ciência da Computação pela Universidade de São Paulo. Especializado em Java e tecnologias relacionadas como Spring Boot e Hibernate, ele tem uma carreira marcada por contribuições em projetos de grande escala, desde sistemas de gerenciamento até aplicações em nuvem.\n" +
                    "\n" +
                    "Reconhecido por sua habilidade em liderar e mentorar equipes, Carlos também contribui para projetos de código aberto e participa ativamente de conferências de tecnologia. Nos tempos livres, ele se dedica a estudar sobre inteligência artificial e a praticar mountain bike.",
            instagram = "@carlossa",
            phone = "(11) 99999-9999",
            email = "carlossa@gmail.com",
            portfolio = listOf(
                Portfolio(
                    name = "/carlossa",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuPIlq1kgrNeQRXx435tS42K13SClJnkv9Ng&usqp=CAU"
                ),
                Portfolio(
                    name = "/abcdef",
                    imageUrl = "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/company-logo-design-template-0c8f73b879606dbc7740c5d752e592ea_screen.jpg?ts=1606800623"
                )
            )
        ), Speaker(
            id = "936237bb-0d79-4300-9afd-5368078f5333",
            shortName = "Manoel",
            fullName = "Manoel Gomez",
            imageUrl = "https://img.freepik.com/free-photo/young-bearded-man-with-striped-shirt_273609-5677.jpg",
            company = "Lab2Dev",
            title = "Especialista SAP",
            companyImageUrl = "https://images.unsplash.com/photo-1599305445671-ac291c95aaa9?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Y29tcGFueSUyMGxvZ298ZW58MHx8MHx8fDA%3D",
            biography = "Manoel Gomez é um especialista em SAP com mais de 12 anos de experiência, focado em soluções de ERP para grandes corporações. Ele possui uma forte base em módulos SAP como FI, CO, SD, MM e HR. Formado em Engenharia de Produção pela Universidade de Campinas, Manoel tem se destacado na implementação e otimização de processos SAP, trabalhando estreitamente com equipes de TI e negócios para garantir integrações eficazes e melhorias contínuas. Ele também é certificado em SAP HANA e regularmente conduz treinamentos e workshops. No seu tempo livre, Manoel é um ávido leitor de literatura técnica e entusiasta de corridas de longa distância.",
            instagram = "@mangomezz",
            phone = "(44) 99999-9999",
            email = "gomezmanoell@gmail.com",
            portfolio = listOf(
                Portfolio(
                    name = "/manoelgo",
                    imageUrl = "https://img.freepik.com/free-vector/abstract-logo-flame-shape_1043-44.jpg"
                )
            )
        ),
        Speaker(
            id = "236257bb-0d69-4300-9atd-5368078f59988",
            shortName = "Mariana",
            fullName = "Mariana Ribeiro",
            imageUrl = "https://blackcreativegroup.com/wp-content/uploads/2021/06/African_American_Woman-1300x866-1.jpeg",
            company = "BR Solutions",
            title = "Desenvolvedora Web Full Stack",
            companyImageUrl = "https://www.logodesign.net/logo/line-art-house-roof-and-buildings-4485ld.png?size=2",
            biography = "Mariana Ribeiro é uma desenvolvedora web full stack com mais de 8 anos de experiência no setor de tecnologia. Formada em Análise de Sistemas pela Universidade Federal do Rio de Janeiro, ela é proficientemente versada em HTML, CSS, JavaScript, React, Node.js e bancos de dados SQL. Mariana tem um histórico comprovado de criação de websites responsivos e aplicativos web dinâmicos para uma variedade de clientes. Ela é apaixonada por design de UI/UX, e sempre busca as mais recentes tendências em desenvolvimento web. Fora do trabalho, Mariana gosta de participar de hackathons e contribuir para projetos de código aberto.",
            instagram = "@maribeiro000",
            phone = "(13) 99999-9999",
            email = "maribeiro@hotmail.com",
            portfolio = listOf(
                Portfolio(
                    name = "/mariri",
                    imageUrl = "https://cdn4.vectorstock.com/i/1000x1000/31/38/building-business-company-logo-vector-19953138.jpg"
                ),
                Portfolio(
                    name = "/github",
                    imageUrl = "https://st3.depositphotos.com/43745012/44906/i/450/depositphotos_449066958-stock-photo-financial-accounting-logo-financial-logo.jpg"
                )
            )
        )
    )

    fun getSpeakerById(speakerId: String): Speaker {
        return speakers.find { it.id == speakerId }!!
    }

    fun getAllSpeakers(): List<Speaker> {
        return speakers
    }

}