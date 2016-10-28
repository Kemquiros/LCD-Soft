/*
    October 28th, 2016
    Author: John Tapias
    This file is part of LCD-Soft.

    LCD-Soft is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 3 as published by
    the Free Software Foundation.

    LCD-Soft is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with LCD-Soft.  If not, see <http://www.gnu.org/licenses/>.
 */
package lcd.soft.controller;

/**
 *
 * This interface manages errors based on codes
 * Error codes allows modular design and scalability
 */
public interface IError {
    abstract void manageError(int error);
}
