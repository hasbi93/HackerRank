/*
 * Solutions to http://sqlzoo.net/wiki/SELECT_within_SELECT_Tutorial
 *
 * Covers subqueries (nested queries) and ALL.
 *
 * Finally, the questions start to get interesting!
 */

-- 1) List each country name where the population is larger than
--    that of 'Russia'.

SELECT name
  FROM world
 WHERE population > (SELECT population
                       FROM world
                      WHERE name = 'Russia');
               

-- 2) Show the countries in Europe with a per capita GDP greater than
-     that of 'United Kingdom'.

SELECT name
  FROM world
 WHERE continent = 'Europe'
   AND gdp/population > (SELECT gdp/population
                           FROM world
                          WHERE name = 'United Kingdom');
     
     
-- 3) List the name and continent of countries in the continents containing 
--    either Argentina or Australia. Order by name of the country.

SELECT name,
       continent
  FROM world
 WHERE continent IN (SELECT continent
                       FROM world
                      WHERE name IN ('Argentina', 'Australia'))
 ORDER BY name;
 
 
-- 4) Which country has a population that is more than Canada's but less than 
--    Poland's? Show the name and the population.

SELECT name,
       population
  FROM world
 WHERE population > (SELECT population
                       FROM world
                      WHERE name = 'Canada')
   AND population < (SELECT population
                       FROM world
                      WHERE name = 'Poland');
            

-- 5 ) Show the name and the population of each country in Europe. 
--     Show the population as a percentage of the population of Germany.
            
SELECT name,
       CONCAT(ROUND(100 * population/(SELECT population
                                        FROM world
                                       WHERE name = 'Germany'),
                    0),
              '%')
  FROM world
 WHERE continent = 'Europe';
 
       /*
        * More than anything, this query tests your ability to match
        *   parentheses and function arguments. I strived to make my
        *   indentation indicate which args belong to which functions.
        */
        
        
/*
 * At this point, SQLzoo warns you that ALL is an "insignificant features
 *   of the language", shortly before suggesting that you use it. I've
 *   included solutions to the remaining questions with and without ALL.
 */
 
        
-- 6) Which countries have a GDP greater than every country in Europe? 
--    Give the name only. (Some countries may have NULL gdp values.)

SELECT name
  FROM world
 WHERE gdp > ALL (SELECT gdp
                   FROM world
                  WHERE continent = 'Europe'
                    AND gdp IS NOT NULL);

    -- 6.1) Alternate solution, not using ALL.

    SELECT name
      FROM world
     WHERE gdp > (SELECT MAX(gdp)
                    FROM world
                   WHERE continent = 'Europe')
                     AND gdp IS NOT NULL);
                     
           /*
            * Note that this alternate solution only needs the "IS NOT NULL"
            *   clause if all `gdp` values are NULL. The first solution
            *   needs it any any `gdp` values are NULL.
            */
                  

-- 7) Find the largest country (by area) in each continent;
--    show the continent, the name and the area.

SELECT continent,
       name,
       area
  FROM world x
 WHERE area >= ALL (SELECT area
                      FROM world y
                     WHERE x.continent = y.continent);
                     
       /*
        * Note the use of table aliases `x` and `y`, both of which refer
        *   to the `world` table. This is a useful query technique.
        */
            
    -- 7.1) Alternate solution, not using ALL.
    
    SELECT continent,
           name,
           area
      FROM world x
     WHERE area = (SELECT MAX(area)
                     FROM world y
                    WHERE x.continent = y.continent)
                
                
-- 8) List each continent and the name of the country that 
--    comes first alphabetically in that continent.

SELECT continent,
       name
  FROM world x
 WHERE name <= ALL (SELECT name
                     FROM world y
                    WHERE x.continent = y.continent);
                    
    -- 8.1) Alternate method, not using ALL.
   
    SELECT continent,
           name
      FROM world x
     WHERE name = (SELECT MIN(name)
                     FROM world y
                    WHERE x.continent = y.continent);
             
    -- 8.2) Another alternate method, using GROUP BY and a column alias.
    --      Makes for a much cleaner, concise query!
    
    SELECT continent,
           MIN(name) AS `name`
      FROM world x
     GROUP BY continent;
     

-- Harder Questions     

-- 9) Find the continents where all countries have a population <= 25000000. 
--    Then find the names of the countries associated with these continents. 
--    Show name, continent and population.

SELECT name,
       continent,
       population
  FROM world x
 WHERE 25000000 >= ALL(SELECT population
                         FROM world y
                        WHERE x.continent = y.continent);

    -- 9.1) Alternate method, not using ALL.
    
    SELECT name,
           continent,
           population
      FROM world
     WHERE continent IN (SELECT continent
                           FROM world
                          GROUP BY continent
                         HAVING MAX(population) <= 25000000);
                         
    -- 9.2) Simpler alternate method, not using ALL.
                            
    SELECT name, 
           continent, 
           population
      FROM world 
     WHERE continent NOT IN (SELECT continent 
                               FROM world 
                              WHERE population > 25000000);
               
               
-- 10) Some countries have populations more than three times that of
--     any of their neighbours (in the same continent). 
--     Give the countries and continents.
       
SELECT name,
       continent
  FROM world x
 WHERE population > ALL(SELECT 3 * population
                          FROM world y
                         WHERE x.continent = y.continent
                           AND x.name <> y.name);
                           
       /*
        * Don't forget to exclude the country itself from the subquery,
        *   since pop > 3*pop is never true (for pop > 0)!
        */
        
    -- 10.1) Alternate solution, not using ALL.
    
    SELECT name,
           continent
      FROM world x
     WHERE population > (SELECT 3 * MAX(population)
                           FROM world y
                          WHERE x.continent = y.continent
                            AND x.name <> y.name);
                            
           /*
            * By now, we see the general pattern; either use ALL to compare
            *   a value to all values in the subquery, or use an aggregate
            *   function like MIN of MAX to extract the relevant value
            *   for comparison.
            */