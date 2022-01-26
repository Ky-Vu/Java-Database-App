INSERT INTO Artist (ID, DOB, FNAME, GENDER, LNAME, NUMOFMONTHLYLISTENERS)
  VALUES (1, '1958-8-29', 'Keenon Daequan', 'Male', 'Jackson', 175192),
         (2, '1992-3-13', 'Juan Carlos', 'Male', 'Rosado', 39604646),
         (3, '1990-3-9', 'Adrian', 'Male', 'von Ziegler', 10536750),
         (4, '1986-5-11', 'Kwon', 'Female', 'Bo-ah', 13248);

INSERT INTO Album (DATERELEASED, NUMSONGS, REVENUE, TITLE, ARTIST_ID)
  VALUES ('2014-1-1', 0, 421500, 'My Krazy Life', 1),
         ('2018-8-3', 0, 1523980, 'Stay Dangerous', 1),
         ('2016-11-25', 0, 48931805, 'Red Friday', 1),
         ('2018-8-24', 0, 4832, 'Aura', 2),
         ('2017-8-25', 0, 879123, 'Odisea', 2),
         ('2012-12-12', 0, 4890321, 'The Celtic Collection', 3),
         ('2002-3-13', 0, 834289, 'Listen to my Heart', 4),
         ('2016-2-15', 0, 973402, 'Outgrow', 4),
         ('2014-9-3', 0, 601432, 'Who''s Back?', 4);

INSERT INTO Genre (TITLE)
  VALUES ('Hip Hop'),
         ('Rap'),
         ('New Age'),
         ('Celtic'),
         ('Pop'),
         ('Dance'),
         ('J-pop'),
         ('R&B'),
         ('Reggaeton'),
         ('Reggae-pop'),
         ('Rock'),
         ('Rock and Roll'),
         ('Dancehall'),
         ('Latin Pop'),
         ('Latin Trap');

INSERT INTO User (ID, EMAIL, FIRSTNAME, LASTNAME, SUBEND, SUBSTART, SUBTYPE)
  VALUES (1, 'dsao;vns@gmail.com', 'Thomas', 'Vu', '2018-3-7', '2018-9-7', 'Premium'),
         (2, 'cnjvxzil@gmail.com', 'Dorothy', 'Nguyen', '2016-9-23', '2019-5-4', 'Basic'),
         (3, 'vxcmkjidfs@gmail.com', 'Michael', 'Wayne', '2014-7-6', '2018-12-12', 'Basic'),
         (4, 'hre9svcz@gmail.com', 'Jocelyn', 'Aspitia', '2018-3-3', '2019-3-3', 'Premium'),
         (5, 'cvkloj@gmail.com', 'Sovathana', 'Deng', '2015-12-25', '2018-12-25', 'Premium');

INSERT INTO Playlist (ID, DATECREATED, NAME, NUMOFSONGS, TOTALDURATION, OWNER_ID)
  VALUES (1, '2015-9-23', 'MyFavs', 0, 23458699, 2),
         (2, '2015-9-23', 'Dump', 0, 23458699, 1),
         (3, '2015-9-23', 'Clarity', 0, 23458699, 4);

INSERT INTO Song (ID, LANGUAGE, LENGTH, PLAYCOUNT, RATING, TITLE, YEARRELEASED)
  VALUES (1, 'English', 237, 133200063, 5, 'Big Bank', 2018),
         (2, 'English', 234, 15063156, 44, 'Left, Right', 2013),
         (3, 'English', 237, 1657854, 54, 'Who Do You Love?', 2014),
         (4, 'English', 223, 133200063, 5, 'I Know', 2016),
         (5, 'English', 208, 133200063, 67, 'I Ain''t Lyin', 2016),
         (6, 'English', 171, 133200063, 88, 'One Time Comin''', 2016),
         (7, 'English', 188, 133200063, 7, 'Aura', 2018),
         (8, 'English', 201, 94683166, 56, 'Ibiza', 2018),
         (9, 'English', 201, 7831267, 72, 'Aunque Me Porte Mal', 2018),
         (10, 'English', 189, 3518920, 22, 'Se Preparo', 2017),
         (11, 'English', 206, 5321098, 78, 'Una Flor', 2017),
         (12, 'English', 237, 813950, 97, 'El Farsante', 2017)
         /*(13, 'English', 219, 951432, 1, 'Work', 2016),
         (14, 'English', 219, 951432, 1, 'Work', 2016),
         (15, 'English', 219, 951432, 1, 'Work', 2016),
         (16, 'English', 219, 951432, 1, 'Work', 2016),
         (17, 'English', 219, 951432, 1, 'Work', 2016),
         (18, 'English', 219, 951432, 1, 'Work', 2016),
         (19, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016),
         (20, 'English', 219, 951432, 1, 'Work', 2016)*/;

INSERT INTO OfficialVideo (YEARRELEASED, TITLE, LENGTH, VIEWCOUNT, SONG_ID)
  VALUES (2016, 'One Time Comin''', 178, 11071646, 6);

INSERT INTO SongInAlbum (songID, albumTitle, albumReleaseDate)
  VALUES (1, 'Stay Dangerous', '2018-8-3'),
         (2, 'My Krazy Life', '2014-1-1'),
         (3, 'My Krazy Life', '2014-1-1'),
         (4, 'Red Friday', '2016-11-25'),
         (5, 'Red Friday', '2016-11-25'),
         (6, 'Red Friday', '2016-11-25'),
         (7, 'Aura', '2018-8-24'),
         (8, 'Aura', '2018-8-24'),
         (9, 'Aura', '2018-8-24'),
         (10, 'Odisea', '2017-8-25'),
         (11, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25')
        /* (12, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25'),
         (12, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (20, 'Odisea', '2017-8-25'),
         (30, 'Odisea', '2017-8-25')*/;

INSERT INTO SongRecord (songs_ID, artists_ID)
  VALUES (1, 1),
         (2, 1),
         (3, 1),
         (4, 1),
         (5, 1),
         (6, 1),
         (7, 2),
         (8, 2),
         (9, 2),
         (10, 2),
         (11, 2),
         (12, 2)
         /*(13, 3),
         (14, 3),
         (15, 3),
         (16, 3),
         (17, 3),
         (18, 3),
         (19, 3),
         (20, 3),
         (21, 3),
         (21, 3),
         (21, 3),
         (21, 3),
         (21, 3),
         (21, 3),
         (21, 3),
         (21, 3),
         (21, 3)*/;

INSERT INTO SongInPlaylist (songs_ID, playlists_ID)
  VALUES (1, 1),
         (6, 2)
        /* (11, 1),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2),
         (6, 2)*/;

INSERT INTO SongGenre (songs_ID, genres_TITLE)
  VALUES (1, 'Hip Hop'),
         (2, 'Hip Hop'),
         (3, 'Hip Hop'),
         (4, 'Hip Hop'),
         (4, 'Rap'),
         (5, 'Hip Hop'),
         (5, 'Rap'),
         (6, 'Hip Hop'),
         (6, 'Rap'),
         (7, 'Reggaeton'),
         (8, 'Reggaeton'),
         (9, 'Reggaeton'),
         (10, 'Reggaeton'),
         (10, 'Latin Trap'),
         (11, 'Reggaeton'),
         (11, 'Latin Trap'),
         (12, 'Reggaeton'),
         (12, 'Latin Trap')
         /*(10, 'Hip Hop'),
         (10, 'Hip Hop'),
         (10, 'Hip Hop'),
         (10, 'Hip Hop'),
         (10, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (20, 'Hip Hop'),
         (30, 'Hip Hop')*/;

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'My Krazy Life')
WHERE Album.TITLE = 'My Krazy Life';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Stay Dangerous')
WHERE Album.TITLE = 'Stay Dangerous';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Red Friday')
WHERE Album.TITLE = 'Red Friday';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Aura')
WHERE Album.TITLE = 'Aura';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Odisea')
WHERE Album.TITLE = 'Odisea';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Requiem')
WHERE Album.TITLE = 'Requiem';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'The Celtic Collection')
WHERE Album.TITLE = 'The Celtic Collection';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Moonsong')
WHERE Album.TITLE = 'Moonsong';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Listen to my Heart')
WHERE Album.TITLE = 'Listen to my Heart';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Outgrow')
WHERE Album.TITLE = 'Outgrow';

UPDATE Album
SET Album.NUMSONGS = (SELECT COUNT(SongInAlbum.songID)
                      FROM SongInAlbum
                      WHERE SongInAlbum.albumTitle = 'Who''s Back?')
WHERE Album.TITLE = 'Who''s Back?';