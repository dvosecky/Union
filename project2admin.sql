
CREATE TABLE account (
    acc_id NUMBER(10),
    uname VARCHAR2(20),
    pw VARCHAR2(30),
    fname VARCHAR2(20),
    lname VARCHAR2(20),
    dep_id NUMBER(10),
    CONSTRAINT account_pk PRIMARY KEY (acc_id)
);

CREATE TABLE department (
    dep_id NUMBER(10),
    dname VARCHAR2(20),
    lead_id NUMBER(10),
    CONSTRAINT department_pk PRIMARY KEY (dep_id)
);

CREATE TABLE event (
    ev_id NUMBER(10),
    ename VARCHAR2(20),
    lead_id NUMBER(10),
    CONSTRAINT event_pk PRIMARY KEY (ev_id)
);

CREATE TABLE invitation (
    acc_id NUMBER(10),
    ev_id NUMBER(10)
);

CREATE TABLE keyperson (
    role_id NUMBER(2),
    acc_id NUMBER(10)
);

ALTER TABLE account ADD CONSTRAINT account_fk FOREIGN KEY (dep_id)
    REFERENCES department (dep_id);
ALTER TABLE department ADD CONSTRAINT department_fk FOREIGN KEY (lead_id)
    REFERENCES account (acc_id);
ALTER TABLE event ADD CONSTRAINT event_fk FOREIGN KEY (lead_id)
    REFERENCES account (acc_id);
ALTER TABLE invitation ADD CONSTRAINT invitation_acc_fk FOREIGN KEY (acc_id)
    REFERENCES account (acc_id);
ALTER TABLE invitation ADD CONSTRAINT invitation_ev_fk FOREIGN KEY (ev_id)
    REFERENCES event (ev_id);
ALTER TABLE keyperson ADD CONSTRAINT keyperson_acc_fk FOREIGN KEY (acc_id)
    REFERENCES account (acc_id);