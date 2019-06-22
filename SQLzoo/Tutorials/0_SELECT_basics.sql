/*
 * Solutions to https://sqlzoo.net/wiki/SELECT_basics
 *
 * Covers basic SELECTS using comparison operators '=', IN, and BETWEEN.
 */

-- 1) Show the population of Germany.

SELECT population
  FROM world
 WHERE name = 'Germany';
 
       /*
        * In standard MySQL, string comparison with '=' is case-sensitive;
        *   in the SQLzoo environment, it is not.
        *
        * In standard MySQL, single or double quotes can be used around
        *   strings; in the SQLzoo environment, they must be single.
        */
        
        
-- 2) Show the name and the population for 'Sweden', 'Norway' and 'Denmark'.
        
SELECT name, 
       population
  FROM world
 WHERE name IN ('Sweden', 'Norway', 'Denmark');
 
 
-- 3) Show the country and the area for countries with an area between 
--    200,000 and 250,000.
 
SELECT name,
       area
  FROM world
 WHERE area BETWEEN 200000 AND 250000;
 
       /*
        *  BETWEEN is inclusive of end values.
        */