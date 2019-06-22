/*
 * Solutions to https://sqlzoo.net/wiki/SELECT_names
 *
 * Covers string pattern matching with LIKE, and the string operator CONCAT.
 */

-- 1) Find the countries that start with 'Y'.

SELECT name
  FROM world
 WHERE name LIKE 'Y%';
 
       /*
        * In standard MySQL, string comparison with LIKE is case-insensitive;
        *   this is also the case in the SQLzoo environment (unlike with '=').
        */
       
       
-- 2) Find the countries that end with 'y'.

SELECT name
  FROM world
 WHERE name LIKE '%y';
 
 
-- 3) Find the countries that contain the letter 'x'.
 
SELECT name
  FROM world
 WHERE name LIKE '%x%';
 
 
-- 4) Find the countries that end with 'land'.

SELECT name
  FROM world
 WHERE name LIKE '%land';
 
 
-- 5) Find the countries that start with 'C' and end with 'ia'.
 
SELECT name
  FROM world
 WHERE name LIKE 'C%'
   AND name LIKE '%ia';
   
   
-- 6) Find the country that has 'oo' in the name.
   
SELECT name
  FROM world
 WHERE name LIKE '%oo%';
 
 
-- 7) Find the countries that have three or more 'a' in the name.

SELECT name 
  FROM world
 WHERE name LIKE '%a%a%a%';

 
-- 8) Find the countries that have 't' as the second character.

SELECT name
  FROM world
 WHERE name LIKE '_t%';
 
 
-- 9) Find the countries that have two 'o' characters separated by two others.

SELECT name
  FROM world
 WHERE name LIKE '%o__o%';
 
       /*
        *  Accidental o__o face, or not? The world may never know...
        */
        
        
-- 10) Find the countries that have exactly four characters.

SELECT name
  FROM world
 WHERE name LIKE '____';
 
 
-- Harder Questions

-- 11) Find the country where the name is the capital city.

SELECT name
  FROM world
 WHERE name = capital;
 
 
-- 12) Find the country where the capital is the country plus "City".

SELECT name
  FROM world
 WHERE capital = CONCAT(name, ' City');
 
 
-- 13) Find the capital and the name where the capital includes 
--     the name of the country.

SELECT capital,
       name
  FROM world
 WHERE capital LIKE CONCAT('%', name, '%');
 
 
-- 14) Find the capital and the name where the capital is an extension of 
--     the name of the country.

SELECT capital,
       name 
  FROM world
 WHERE capital LIKE CONCAT(name, '_%');

       /*
        * This solution assumes the question means that the capital begins
        * with the name of the country, and has some extension after it.
        */
        
        
-- 15) Show the name and the extension where the capital is an extension of 
--     the name of the country.

SELECT name, 
       REPLACE(capital, name, '')
  FROM world
 WHERE capital LIKE CONCAT(name, '_%');
 
       /*
        * Same assumption as made on the previous question.
        *
        * REPLACE replaces its second argument with its third, in the string
        *   given in the first argument.
        */