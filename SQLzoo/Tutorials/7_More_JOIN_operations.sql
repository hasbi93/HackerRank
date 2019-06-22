/*
 * Solutions to https://sqlzoo.net/wiki/More_JOIN_operations
 *
 * Covers JOIN (INNER), with many nested queries.
 */

 
-- 1) List the films (id and title) where `yr` is 1962.

SELECT id, 
       title
  FROM movie
 WHERE yr = 1962;
 
 
-- 2) Give year of 'Citizen Kane'.

SELECT yr
  FROM movie
 WHERE title = 'Citizen Kane';
 
 
-- 3) List all of the Star Trek movies (id, title and yr). All of these movies
--    include the words "Star Trek" in the title. Order results by year. 
 
SELECT id,
       title,
       yr
  FROM movie
 WHERE title LIKE '%Star Trek%'
 ORDER BY yr;
 
 
-- 4) What id number does the actor 'Glenn Close' have?
 
SELECT id
  FROM actor
 WHERE name = 'Glenn Close';
 
 
-- 5) What is the id of the film 'Casablanca'?
 
SELECT id
  FROM movie
 WHERE title = 'Casablanca';
 
 
-- 6) Obtain the cast list for 'Casablanca'. 

SELECT name
  FROM actor 
       INNER JOIN casting
       ON id = actorid
 WHERE movieid = 11768;
 
       /*
        * The instructions encourage hardcoding Casablanca's id...
        */
        
    -- 6.1) Alternate solution, without the hardcoding.
 
    SELECT name
      FROM actor
           INNER JOIN casting
           ON id = actorid
     WHERE movieid = (SELECT id
                        FROM movie
                       WHERE title = 'Casablanca');
                          
                          
-- 7) Obtain the cast list for the film 'Alien'.

SELECT name
  FROM actor
       INNER JOIN casting
       ON id = actorid
 WHERE movieid = (SELECT id
                    FROM movie
                   WHERE title = 'Alien');
                   
       /*
        * As in 6.1, I'm opting not to hardcode the id for 'Alien' here.
        */    

-- 8) List the films in which 'Harrison Ford' has appeared.
        
SELECT title
  FROM movie
 WHERE id IN (SELECT movieid
                FROM casting
               WHERE actorid = 2216);
               
       /*
        * Harrison Ford's id is hardcoded here.
        */ 
          
    -- 8.1) Alternate solution, without the hardcoding.          
               
    SELECT title
      FROM movie
     WHERE id IN (SELECT movieid
                    FROM casting
                   WHERE actorid = (SELECT id
                                      FROM actor
                                     WHERE name = 'Harrison Ford'));
      
      
-- 9) List the films where 'Harrison Ford' has appeared - but not in the 
--    starring role. (Note: the `ord` field of `casting` gives the position of 
--    the actor. If ord = 1, then this actor is in the starring role.)

SELECT title
  FROM movie
       INNER JOIN casting
       ON id = movieid
 WHERE actorid = 2216
   AND ord <> 1;
   
       /*
        * Once again, this is the hardcoded solution.
        */
   
    -- 9.1) Alternate solution, without the hardcoding.        

       SELECT title
         FROM movie
              INNER JOIN casting
              ON id = movieid
        WHERE actorid = (SELECT id
                           FROM actor
                          WHERE name = 'Harrison Ford')
          AND ord <> 1;
          
          
-- 10) List the films together with the leading star for all 1962 films.
          
SELECT title,
       name
  FROM movie
       INNER JOIN casting
       ON movie.id = movieid

       INNER JOIN actor
       ON actor.id = actorid
 WHERE yr = 1962
   AND ord = 1;
   

-- Harder Questions
   
-- 11) Which were the busiest years for 'John Travolta'? Show the year and the
--     number of movies he made each year, for any year in which he made 
--     more than 2 movies. 

SELECT yr,
       COUNT(title) 
  FROM movie 
       INNER JOIN casting 
       ON movie.id = movieid
       
       INNER JOIN actor
       ON actor.id = actorid
 WHERE name = 'John Travolta'
 GROUP BY yr
HAVING COUNT(title) > 2;


-- 12) List the film title and the leading actor for all of the films 
--     'Julie Andrews' played in.

SELECT title,
       name
  FROM movie 
       INNER JOIN casting
       ON movie.id = movieid
       
       INNER JOIN actor
       ON actor.id = actorid
 WHERE movie.id IN (SELECT movieid
                      FROM casting
                     WHERE actorid IN (SELECT id
                                         FROM actor
                                        WHERE name = 'Julie Andrews'))
   AND ord = 1;
   
   
-- 13) Obtain a list, in alphabetical order, of actors who've had 
--     at least 30 starring roles.

SELECT name
  FROM actor
       INNER JOIN casting
       ON actor.id = actorid
 WHERE ord = 1
 GROUP BY name
HAVING COUNT(*) >= 30
 ORDER BY name;
 
 
-- 14) List the films released in the year 1978, ordered by the 
--     number of actors in the cast, then by title. 

SELECT title,
       COUNT(actorid)
  FROM movie
       INNER JOIN casting
       ON id = movieid                
 WHERE yr = 1978
 GROUP BY title
 ORDER BY COUNT(actorid) DESC,
          title ASC;
          
       /*
        * Needs the column with a count of cast members to be marked "correct",
        *   even though it wasn't mentioned in the problem statement.
        */

          
-- 15) List all the people who have worked with 'Art Garfunkel'.
          
SELECT DISTINCT name
  FROM actor
       INNER JOIN casting
       ON id = actorid
 WHERE movieid IN (SELECT movieid
                     FROM casting
                    WHERE actorid = (SELECT id
                                       FROM actor
                                      WHERE name = 'Art Garfunkel'))
   AND name <> 'Art Garfunkel';