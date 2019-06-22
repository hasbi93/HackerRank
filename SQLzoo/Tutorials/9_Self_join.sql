/*
 * Solutions to https://sqlzoo.net/wiki/Self_join
 *
 * Doesn't cover any new material; just provides more practice.
 */

-- 1) How many stops are in the database?

SELECT COUNT(DISTINCT id)
  FROM stops;
        
        
-- 2) Find the id value for the stop 'Craiglockhart'.

SELECT id
  FROM stops
 WHERE name = 'Craiglockhart';
 

-- 3) Give the id and the name for the stops on the '4' 'LRT' service.

SELECT id,
       name
  FROM stops
       INNER JOIN route
       ON stop = id
 WHERE num = 4
   AND company = 'LRT';
   

-- 4) Run the query and notice the two services that link these stops have
--    a count of 2. Add a HAVING clause to restrict the output to these 
--    two routes.

SELECT company, 
       num, 
       COUNT(*)
  FROM route
 WHERE stop = 149 
    OR stop = 53
 GROUP BY company, num
HAVING COUNT(*) = 2;


-- 5) Change the query so that it shows the services from Craiglockhart to 
--    London Road.

SELECT a.company, 
       a.num, 
       a.stop, 
       b.stop
  FROM route a 
       INNER JOIN route b 
       ON (a.company = b.company AND a.num = b.num)
  WHERE a.stop = 53
    AND b.stop = 149;
    
    
-- 6) Change the query so that the services between 'Craiglockhart' and 
--    'London Road' are shown.

SELECT a.company,
       a.num,
       s1.name,
       s2.name
  FROM route a 
       INNER JOIN route b 
       ON (a.company = b.company AND a.num = b.num)

       INNER JOIN stops s1 
       ON (a.stop = s1.id)

       INNER JOIN stops s2 
       ON (b.stop = s2.id)
 WHERE s1.name = 'Craiglockhart'
   AND s2.name = 'London Road';
   
   
-- 7) Give a list of all the services which connect stops 115 and 137.

SELECT DISTINCT a.company, 
       a.num
  FROM route a 
       INNER JOIN route b 
       ON (a.company = b.company AND a.num = b.num)
  WHERE a.stop = 115
    AND b.stop = 137;
    
   
-- 8) Give a list of the services which connect the stops 'Craiglockhart' 
--    and 'Tollcross'.

SELECT a.company,
       a.num
  FROM route a 
       INNER JOIN route b
       ON (a.company = b.company AND a.num = b.num)

       INNER JOIN stops s1 
       ON (a.stop = s1.id)

       INNER JOIN stops s2 
       ON (b.stop = s2.id)
 WHERE s1.name = 'Craiglockhart'
   AND s2.name = 'Tollcross';
   
   
-- 9) Give a distinct list of the stops which may be reached from 
--    'Craiglockhart' by taking one bus, including 'Craiglockhart' itself, 
--    offered by the LRT company. Include the company and bus no. of 
--    the relevant services.

SELECT DISTINCT s2.name,
       r2.company,
       r2.num
  FROM stops s1
       INNER JOIN route r1
       ON s1.id = r1.stop

       INNER JOIN route r2
       ON (r1.company = r2.company AND r1.num = r2.num)

       INNER JOIN stops s2
       ON s2.id = r2.stop
WHERE s1.name = 'Craiglockhart'
  AND r2.company = 'LRT';
  
  
-- 10) Find the routes involving two buses that can go from Craiglockhart to 
--     Sighthill. Show the bus number and company for the first bus, the name
--     of the stop for the transfer, and the bus number and company for the 
--     second bus.

SELECT DISTINCT r1.num, 
       r1.company, 
       stops.name, 
       r2.num, 
       r2.company
  FROM (SELECT a.company, /* all stops reachable one ride from Craiglockhart */
               a.num,
               b.stop
          FROM route a
               INNER JOIN route b 
               ON (a.company = b.company AND a.num = b.num)
         WHERE a.stop = (SELECT id FROM stops WHERE name = 'Craiglockhart')
        ) r1

        INNER JOIN (SELECT a.company,  /* all stops reachable one ride from Sighthill */
                           a.num, 
                           b.stop
                      FROM route a 
                           INNER JOIN route b 
                           ON (a.company = b.company AND a.num = b.num)
                     WHERE a.stop = (SELECT id FROM stops WHERE name= 'Sighthill')
                    ) r2
        ON (r1.stop = r2.stop) /* transfer stops (by id) */

        INNER JOIN stops 
        ON (stops.id = r1.stop); /* join this to get names of stops */