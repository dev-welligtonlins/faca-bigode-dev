




## Extensões
    Thunder Client
    Spring Boot Tools


# RODAR
## Back-end e Banco de dados
    cd back-end
    mvn spring-boot:run

    postgres
    executar scripts bd_dados.sql e bd_tables.sql
    user: postgres password: root



# FERRAMENTAS

## JAVA
    Acesse: https://www.oracle.com/br/java/technologies/downloads/#java21

    Download
    Instalador x64: https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe

    Variavel de ambiente
    Crie uma nova variavel de ambiente de nome: JAVA_HOME e valor: C:\Program Files\Java\jdk-21.
    Em seguinda, adicione %JAVA_HOME%\bin na variavel PATH.

    Tutorial
    https://mkyong.com/java/how-to-set-java_home-on-windows-10/

    Teste 
    javac -version
        javac 21.0.7


## MAVEN

    Acesse: https://maven.apache.org/download.cgi

    Versão estável 3.9.11
        Instalador ZIP: https://dlcdn.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip

    Variavel de ambiente
        Crie uma nova variavel de ambiente de nome: MAVEN_HOME e valor:C:\Program Files\apache-maven-3.8.8.
        Em seguinda, adicione MAVEN_HOME%\bin na variavel PATH. 

    Tutorial
        https://mkyong.com/maven/how-to-install-maven-in-windows/

    Teste 
        mvn -version
            Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
            Maven home: C:\Program Files\apache-maven-3.9.11
            Java version: 21.0.8, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-21
            Default locale: pt_BR, platform encoding: UTF-8
            OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"


## POSTGRESQL

    Acesse: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

    Versão estável 18.1
        Instalador: https://sbp.enterprisedb.com/getfile.jsp?fileid=1259914 

    Tutorial
        [https://mkyong.com/maven/how-to-install-maven-in-windows/](https://www.w3schools.com/postgresql/postgresql_install.php)

    Teste 
        postgres --version
            
            
            

## Fedora

## Back-end e Banco de dados
### JAVA
  instalação:
  sudo dnf install java-21-openjdk java-21-openjdk-devel
  test: java -version
  
  variavel de ambiente:
  echo 'export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))' >> ~/.bashrc
  source ~/.bashrc
  
  test: echo $JAVA_HOME

  
### MAVEN
  instalação:
  cd /opt
  sudo wget https://downloads.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.tar.gz
  sudo tar -xvzf apache-maven-3.9.11-bin.tar.gz
  sudo mv apache-maven-3.9.11 /opt/maven
  
  variavel de ambiente:
  echo 'export M2_HOME=/opt/maven' >> ~/.bashrc
  echo 'export PATH=$M2_HOME/bin:$PATH' >> ~/.bashrc
  echo 'export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))' >> ~/.bashrc
  source ~/.bashrc

  test: mvn -version
  
### POSTGRESQL

  instalação:
  sudo dnf install postgresql-server postgresql-contrib

  inicializar, iniciar e habilitar o serviço:
  sudo postgresql-setup --initdb
  sudo systemctl enable postgresql
  sudo systemctl start postgresql
  
  test: sudo -i -u postgres
  
  interface gráfica:
  sudo dnf install pgadmin4

