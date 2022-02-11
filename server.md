server {
    listen 443 ssl;
    #配置HTTPS的默认访问端口为443。
    #如果未在此处配置HTTPS的默认访问端口，可能会造成Nginx无法启动。
    #如果您使用Nginx 1.15.0及以上版本，请使用listen 443 ssl代替listen 443和ssl on。
    server_name yourdomain.com; #需要将yourdomain.com替换成证书绑定的域名。
    root html;
    index index.html index.htm;
    ssl_certificate /usr/local/nginx/cert/7232961_bugcc.top.pem;  #需要将cert-file-name.pem替换成已上传的证书文件的名称。
    ssl_certificate_key /usr/local/nginx/cert/7232961_bugcc.top.key; #需要将cert-file-name.key替换成已上传的证书私钥文件的名称。
    ssl_session_timeout 5m;
    ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
    #表示使用的加密套件的类型。
    ssl_protocols TLSv1.1 TLSv1.2 TLSv1.3; #表示使用的TLS协议的类型。
    ssl_prefer_server_ciphers on;
    location / {
        root html;  #站点目录。
        index index.html index.htm;
    }

}

server {
    listen 80;
    server_name bugcc.top; #需要将yourdomain.com替换成证书绑定的域名。
    rewrite ^(.*)$ https://$host$1; #将所有HTTP请求通过rewrite指令重定向到HTTPS。
    location / {
        index index.html index.htm;
    }
}




scp /Users/shenjun/Downloads/7232961_bugcc.top_nginx.zip root@8.142.103.16:/usr/local/nginx/cert


https://help.aliyun.com/document_detail/146190.html

/Users/shenjun/Documents/cocoa/cclab/dist.zip

<a href="https://beian.miit.gov.cn/" target="_blank">浙ICP备18015548号-3</a>



scp /Users/shenjun/Documents/cocoa/cclab/dist/dist.zip root@8.142.103.16:/usr/share/nginx/html