/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package org.restcomm.sbc.bo;

import java.net.URI;

import org.joda.time.DateTime;

import org.restcomm.sbc.annotations.concurrency.Immutable;

/**
 * Represent a user Account
 *
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
@Immutable
public final class Account {
    private final Sid sid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String emailAddress;
    private final String friendlyName;
    private final Sid accountSid;
    private final Type type;
    private final Status status;
    private final String authToken;
    private final String role;
    private final URI uri;

    public Account(final Sid sid, final DateTime dateCreated, final DateTime dateUpdated, final String emailAddress,
            final String friendlyName, final Sid accountSid, final Type type, final Status status, final String authToken,
            final String role, final URI uri) {
        super();
        this.sid = sid;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.emailAddress = emailAddress;
        this.friendlyName = friendlyName;
        this.accountSid = accountSid;
        this.type = type;
        this.status = status;
        this.authToken = authToken;
        this.role = role;
        this.uri = uri;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Sid getSid() {
        return sid;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateUpdated() {
        return dateUpdated;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Sid getAccountSid() {
        return accountSid;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getRole() {
        return role;
    }

    public URI getUri() {
        return uri;
    }

    public Account setEmailAddress(final String emailAddress) {
        return new Account(sid, dateCreated, DateTime.now(), emailAddress, friendlyName, accountSid, type, status, authToken,
                role, uri);
    }

    public Account setFriendlyName(final String friendlyName) {
        return new Account(sid, dateCreated, DateTime.now(), emailAddress, friendlyName, accountSid, type, status, authToken,
                role, uri);
    }

    public Account setType(final Type type) {
        return new Account(sid, dateCreated, DateTime.now(), emailAddress, friendlyName, accountSid, type, status, authToken,
                role, uri);
    }

    public Account setStatus(final Status status) {
        return new Account(sid, dateCreated, DateTime.now(), emailAddress, friendlyName, accountSid, type, status, authToken,
                role, uri);
    }

    public Account setAuthToken(final String authToken) {
        return new Account(sid, dateCreated, DateTime.now(), emailAddress, friendlyName, accountSid, type, status, authToken,
                role, uri);
    }

    public Account setRole(final String role) {
        return new Account(sid, dateCreated, DateTime.now(), emailAddress, friendlyName, accountSid, type, status, authToken,
                role, uri);
    }

    public enum Status {
        ACTIVE("active"), CLOSED("closed"), SUSPENDED("suspended"), INACTIVE("inactive"), UNINITIALIZED("uninitialized");

        private final String text;

        private Status(final String text) {
            this.text = text;
        }

        public static Status getValueOf(final String text) {
            Status[] values = values();
            for (final Status value : values) {
                if (value.toString().equals(text)) {
                    return value;
                }
            }
            throw new IllegalArgumentException(text + " is not a valid account status.");
        }

        @Override
        public String toString() {
            return text;
        }
    };

    public enum Type {
        FULL("Full"), TRIAL("Trial");

        private final String text;

        private Type(final String text) {
            this.text = text;
        }

        public static Type getValueOf(final String text) {
            Type[] values = values();
            for (final Type value : values) {
                if (value.text.equals(text)) {
                    return value;
                }
            }
            throw new IllegalArgumentException(text + " is not a valid account type.");
        }

        @Override
        public String toString() {
            return text;
        }
    };

    public static final class Builder {
        private Sid sid;
        private String emailAddress;
        private String friendlyName;
        private Sid accountSid;
        private Type type;
        private Status status;
        private String authToken;
        private String role;
        private URI uri;

        private Builder() {
            super();
        }

        public Account build() {
            final DateTime now = DateTime.now();
            return new Account(sid, now, now, emailAddress, friendlyName, accountSid, type, status, authToken, role, uri);
        }

        public void setSid(final Sid sid) {
            this.sid = sid;
        }

        public void setEmailAddress(final String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public void setFriendlyName(final String friendlyName) {
            this.friendlyName = friendlyName;
        }

        public void setAccountSid(final Sid accountSid) {
            this.accountSid = accountSid;
        }

        public void setType(final Type type) {
            this.type = type;
        }

        public void setStatus(final Status status) {
            this.status = status;
        }

        public void setAuthToken(final String authToken) {
            this.authToken = authToken;
        }

        public void setRole(final String role) {
            this.role = role;
        }

        public void setUri(final URI uri) {
            this.uri = uri;
        }
    }
}
