#FROM node:carbon
#
#COPY ./dist  ng
#COPY ./package-production.json ng/package-production
#
#RUN npm install
#
#RUN npm install http-server -g
#
#WORKDIR /ng/dist
#
#CMD ["http-server", "-c1" , "-p", "8030"]
FROM node:8.11.2-alpine as node

RUN npm install
COPY . .
# RUN npm run build

# Stage 2
FROM node
RUN npm install http-server -g
CMD ["http-server","-p","8030", "dist/AngularJwtAuth"]
