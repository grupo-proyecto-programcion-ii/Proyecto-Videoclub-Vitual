/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, version 2.0, as published by the
 * Free Software Foundation.
 *
 * This program is also distributed with certain software (including but not
 * limited to OpenSSL) that is licensed under separate terms, as designated in a
 * particular file or component or in included license documentation. The
 * authors of MySQL hereby grant you an additional permission to link the
 * program and your derivative works with the separately licensed software that
 * they have included with MySQL.
 *
 * Without limiting anything contained in the foregoing, this file, which is
 * part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at
 * http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0,
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301  USA
 */

package com.mysql.cj.protocol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

import org.junit.Test;

import com.mysql.cj.exceptions.DataConversionException;
import com.mysql.cj.exceptions.DataReadException;
import com.mysql.cj.result.LocalDateTimeValueFactory;

public class LocalDateTimeValueFactoryTest extends CommonAsserts {

    @Test
    public void testBasics() {
        LocalDateTimeValueFactory vf = new LocalDateTimeValueFactory();

        assertThrows(DataConversionException.class, "Unsupported conversion from DECIMAL to java.time.LocalDateTime", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromBigDecimal(new BigDecimal("2018"));
                return null;
            }
        });

        assertThrows(DataConversionException.class, "Unsupported conversion from BIGINT to java.time.LocalDateTime", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromBigInteger(new BigInteger("2018"));
                return null;
            }
        });

        assertThrows(DataConversionException.class, "Unsupported conversion from BIT to java.time.LocalDateTime", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromBit(new byte[] { 1 }, 0, 2);
                return null;
            }
        });

        assertThrows(DataConversionException.class, "Unsupported conversion from VARCHAR/TEXT/BLOB to java.time.LocalDateTime", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromBytes(new byte[] { 1 }, 0, 2);
                return null;
            }
        });

        assertEquals(LocalDateTime.of(2018, 1, 1, 0, 0, 0, 0), vf.createFromDate(2018, 1, 1));

        assertThrows(DataConversionException.class, "Unsupported conversion from DOUBLE to java.time.LocalDateTime", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromDouble(new Double(2018));
                return null;
            }
        });

        assertThrows(DataConversionException.class, "Unsupported conversion from LONG to java.time.LocalDateTime", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromLong(22L);
                return null;
            }
        });

        assertNull(vf.createFromNull());

        assertThrows(DataReadException.class,
                "The value '-1:0:0' is an invalid TIME value. JDBC Time objects represent a wall-clock time and not a duration as MySQL treats them. If you are treating this type as a duration, consider retrieving this value as a string and dealing with it according to your requirements.",
                new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        vf.createFromTime(-1, 0, 0, 0);
                        return null;
                    }
                });

        assertThrows(DataReadException.class,
                "The value '44:0:0' is an invalid TIME value. JDBC Time objects represent a wall-clock time and not a duration as MySQL treats them. If you are treating this type as a duration, consider retrieving this value as a string and dealing with it according to your requirements.",
                new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        vf.createFromTime(44, 0, 0, 0);
                        return null;
                    }
                });

        assertEquals(LocalDateTime.of(1970, 1, 1, 1, 1, 1, 1), vf.createFromTime(1, 1, 1, 1));

        assertThrows(DataReadException.class, "Zero date value prohibited", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                vf.createFromTimestamp(0, 0, 0, 1, 1, 1, 1);
                return null;
            }
        });
        assertThrows(DateTimeException.class, "Invalid value for MonthOfYear \\(valid values 1 - 12\\): 0", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                assertEquals(LocalDateTime.of(0, 0, 1, 1, 1, 1, 1), vf.createFromTimestamp(0, 0, 1, 1, 1, 1, 1));
                return null;
            }
        });
        assertThrows(DateTimeException.class, "Invalid value for DayOfMonth \\(valid values 1 - 28/31\\): 0", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                assertEquals(LocalDateTime.of(0, 1, 0, 1, 1, 1, 1), vf.createFromTimestamp(0, 1, 0, 1, 1, 1, 1));
                return null;
            }
        });

        assertEquals(LocalDateTime.of(0, 1, 1, 1, 1, 1, 1), vf.createFromTimestamp(0, 1, 1, 1, 1, 1, 1));

        assertThrows(DateTimeException.class, "Invalid value for MonthOfYear \\(valid values 1 - 12\\): 0", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                assertEquals(LocalDateTime.of(2018, 0, 0, 1, 1, 1, 1), vf.createFromTimestamp(2018, 0, 0, 1, 1, 1, 1));
                return null;
            }
        });
        assertThrows(DateTimeException.class, "Invalid value for MonthOfYear \\(valid values 1 - 12\\): 0", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                assertEquals(LocalDateTime.of(2018, 0, 1, 1, 1, 1, 1), vf.createFromTimestamp(2018, 0, 1, 1, 1, 1, 1));
                return null;
            }
        });
        assertThrows(DateTimeException.class, "Invalid value for DayOfMonth \\(valid values 1 - 28/31\\): 0", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                assertEquals(LocalDateTime.of(2018, 1, 0, 1, 1, 1, 1), vf.createFromTimestamp(2018, 1, 0, 1, 1, 1, 1));
                return null;
            }
        });
        assertEquals(LocalDateTime.of(2018, 1, 1, 1, 1, 1, 1), vf.createFromTimestamp(2018, 1, 1, 1, 1, 1, 1));

        assertEquals("java.time.LocalDateTime", vf.getTargetTypeName());
    }
}
