#Spring Security with JWt Token

Demo project with Customer login, have user-roles. Exposing 2 APIs.
1._localhost:8088/test/authenticated_ POST body:{"username":"xxx","password":"john"}<br>
2._localhost:8088/secure/user?name=User&conditional=true_

master_branch is basic default spring security with **UserDetailsService** login<br>
non_unique_username_branch is added with **AuthenticationProvider** 
