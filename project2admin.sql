DROP TABLE account CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;
DROP TABLE event CASCADE CONSTRAINTS;
DROP TABLE invitation CASCADE CONSTRAINTS;

CREATE TABLE account (
    acc_id NUMBER(10),
    uname VARCHAR2(20),
    pw VARCHAR2(30),
    fname VARCHAR2(20),
    lname VARCHAR2(20),
    dep_id NUMBER(10),
    role NUMBER(1),
    CONSTRAINT account_pk PRIMARY KEY (acc_id)
);

CREATE TABLE department (
    dep_id NUMBER(10),
    dname VARCHAR2(20),
    CONSTRAINT department_pk PRIMARY KEY (dep_id)
);

CREATE TABLE event (
    ev_id NUMBER(10),
    ename VARCHAR2(20),
    etime TIMESTAMP,
    lead_id NUMBER(10),
    CONSTRAINT event_pk PRIMARY KEY (ev_id)
);

CREATE TABLE invitation (
    inv_id NUMBER(10),
    acc_id NUMBER(10),
    ev_id NUMBER(10),
    accept_flag NUMBER(1),
    priv_flag NUMBER(1),
    CONSTRAINT invitation_pk PRIMARY KEY (inv_id)
);

ALTER TABLE account ADD CONSTRAINT account_fk FOREIGN KEY (dep_id)
    REFERENCES department (dep_id);
ALTER TABLE event ADD CONSTRAINT event_leadfk FOREIGN KEY (lead_id)
    REFERENCES account (acc_id);
ALTER TABLE invitation ADD CONSTRAINT invitation_acc_fk FOREIGN KEY (acc_id)
    REFERENCES account (acc_id);
ALTER TABLE invitation ADD CONSTRAINT invitation_ev_fk FOREIGN KEY (ev_id)
    REFERENCES event (ev_id);
    
INSERT INTO department VALUES(1, 'gogo');
INSERT INTO department VALUES(2, 'coolguys');
INSERT INTO account VALUES(1, 'd', 'd', 'd', 'd', 1, 0);
INSERT INTO account VALUES(2, 'a', 'a', 'a', 'a', 1, 0);
INSERT INTO account VALUES(3, 'guy', '7', '8', '9', 2, 0);
INSERT INTO event VALUES(1, 'meeting', TO_TIMESTAMP('11-11-1994','dd-mm-yyyy'), 1);
INSERT INTO event VALUES(2, 'conference', TO_TIMESTAMP('12-12-1994','dd-mm-yyyy'), 1);
INSERT INTO event VALUES(3, 'conference', TO_TIMESTAMP('12-12-1994','dd-mm-yyyy'), 3);
INSERT INTO invitation VALUES(1, 1, 1, 0, 0);
INSERT INTO invitation VALUES(2, 2, 1, 0, 0);
INSERT INTO invitation VALUES(3, 3, 1, 0, 0);
INSERT INTO invitation VALUES(4, 3, 3, 0, 0);

SELECT * FROM account;
SELECT * FROM event;
SELECT * FROM invitation;

DESC event;

commit;

