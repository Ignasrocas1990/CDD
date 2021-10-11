/*
 * Copyright (C) 2021 ignas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package synchronisedFix;

/**
 * @author Ignas Rocas
 * @since 11/10/2021
 * Short and long description
 * <p>
 * Integer Class to use to increment number with using synchronization.
 * <p>
 */
class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }
        /**
     * this method used to increment object variable
     * @return int not used
     */
    synchronized int inc(){
        this.value++;
        return this.value;
    }
}
