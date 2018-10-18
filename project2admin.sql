
CREATE TABLE account (
    acc_id NUMBER(10),
    uname VARCHAR2(20),
    pw VARCHAR2(30),
    fname VARCHAR2(20),
    lname VARCHAR2(20),
    dep_id NUMBER(10)
);

CREATE TABLE department (
    dep_id NUMBER(10),
    dname VARCHAR2(20),
    lead_id NUMBER(10)
);

CREATE TABLE event (
    ev_id NUMBER(10),
    ename VARCHAR2(20),
    lead_id NUMBER(10),
    CONSTRAINT event_pk PRIMARY KEY (ev_id),
    CONSTRAINT event_fk FOREIGN KEY (lead_id)
    REFERENCES account (acc_id)
);

CREATE TABLE invitation (
    acc_id NUMBER(10),
    ev_id NUMBER(10),
    CONSTRAINT invitation_acc_fk FOREIGN KEY (acc_id)
    REFERENCES account (acc_id),
    CONSTRAINT invitation_ev_fk FOREIGN KEY (ev_id)
    REFERENCES account (ev_id)
);

CREATE TABLE keyperson (
    role_id NUMBER(2),
    acc_id NUMBER(10),
    CONSTRAINT invitation_ev_fk FOREIGN KEY (ev_id)
    REFERENCES account (ev_id)
);