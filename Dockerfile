# Use a base image
FROM tomcat:10.1-jdk21

# Set the working directory
WORKDIR /usr/local/tomcat

# Remove default web applications
RUN rm -rf webapps/*

# Copy your WAR file into the webapps directory
COPY build/register.war webapps/register.war

# Expose the default Tomcat port
EXPOSE 8087

# Start Tomcat
CMD ["catalina.sh", "run"]
