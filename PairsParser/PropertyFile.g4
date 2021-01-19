grammar PropertyFile;

file: props+;
props: ID '=' STRING '\r'? '\n' ;

ID: [a-zA-Z_]+ [a-zA-Z_0-9]*;
STRING: '"' .*? '"';
