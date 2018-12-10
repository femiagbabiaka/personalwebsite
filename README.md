# personalwebsite

a website

## Usage

### Local Setup
```bash
[femi@socrates personalwebsite]$ lein repl
2018-12-09 21:26:44.428:INFO::main: Logging initialized @1785ms
nREPL server started on port 40595 on host 127.0.0.1 - nrepl://127.0.0.1:40595
REPL-y 0.3.7, nREPL 0.2.12
Clojure 1.9.0
OpenJDK 64-Bit Server VM 11.0.1+13
    Docs: (doc function-name-here)
          (find-doc "part-of-name-here")
  Source: (source function-name-here)
 Javadoc: (javadoc java-object-or-class-here)
    Exit: Control+D or (exit) or (quit)
 Results: Stored in vars *1, *2, *3, an exception in *e

personalwebsite.web=> (-main)
2018-12-09 21:26:54.401:INFO:oejs.Server:nREPL-worker-0: jetty-9.2.10.v20150310
2018-12-09 21:26:54.425:INFO:oejs.ServerConnector:nREPL-worker-0: Started ServerConnector@966556f{HTTP/1.1}{0.0.0.0:8080}
2018-12-09 21:26:54.426:INFO:oejs.Server:nREPL-worker-0: Started @11783ms
#object[org.eclipse.jetty.server.Server 0x6b464fa3 "org.eclipse.jetty.server.Server@6b464fa3"]
```

Open `localhost:8080` in your browser. There's also an included Dockerfile.

