CREATE TABLE
    RIGHTS
    (
        ID bigint DEFAULT '0' NOT NULL,
        NAME VARCHAR(100),
        ID_RIGHT bigint,
        PRIMARY KEY (ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
    
    
    CREATE TABLE
    ROLES
    (
        ID bigint NOT NULL,
        ROLE VARCHAR(100),
        RIGHTS bigint,
        PRIMARY KEY (ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
    
    CREATE TABLE
    USERS
    (
        ID bigint NOT NULL,
        LOGIN VARCHAR(100),
        PASSWORD VARCHAR(100),
        ROLE bigint,
        PRIMARY KEY (ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
