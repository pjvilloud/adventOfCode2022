package com.adventOfCode.y2022;

import java.util.stream.IntStream;

public class Day04 {
    public static final String TEST_INPUT = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8""";


    public static final String INPUT = """
            75-76,18-75
            2-54,1-50
            82-83,78-82
            13-37,37-75
            79-80,2-80
            29-90,30-89
            13-16,12-15
            20-93,20-94
            90-95,33-90
            16-77,76-92
            42-52,15-52
            6-34,9-89
            13-77,12-76
            18-81,17-81
            2-34,2-33
            17-92,20-93
            24-89,7-11
            6-49,27-49
            17-69,16-69
            34-57,35-58
            71-76,73-87
            69-72,70-72
            30-70,29-69
            48-85,52-84
            14-69,13-15
            2-61,3-70
            17-86,17-85
            7-98,8-98
            8-93,12-94
            16-35,35-49
            13-59,13-79
            5-95,4-95
            2-40,2-39
            16-44,22-60
            8-26,9-27
            48-89,88-91
            19-97,18-20
            10-81,9-9
            3-40,58-73
            2-93,92-92
            77-83,73-84
            7-84,6-6
            35-45,38-59
            28-79,57-74
            52-82,55-83
            60-60,9-60
            63-86,40-64
            44-80,13-26
            17-67,19-75
            33-69,5-68
            5-31,4-54
            81-82,64-81
            55-92,55-95
            28-29,29-82
            34-93,33-33
            88-95,62-88
            64-81,65-81
            81-82,64-81
            28-94,28-94
            9-76,6-75
            34-36,35-58
            86-89,12-89
            29-31,30-31
            46-78,83-87
            11-77,1-11
            27-34,37-68
            3-4,4-93
            7-89,89-90
            18-94,14-16
            28-89,10-88
            89-91,33-89
            17-53,17-52
            70-87,70-86
            1-33,1-86
            67-68,33-67
            13-75,14-27
            26-73,26-72
            28-57,17-19
            65-65,3-65
            5-92,28-29
            2-19,19-81
            29-42,29-37
            16-70,47-87
            5-77,1-2
            28-40,28-41
            98-98,10-98
            11-21,3-74
            4-32,5-31
            5-98,4-4
            23-99,22-97
            77-99,82-94
            8-91,9-91
            1-60,59-93
            9-11,10-37
            88-88,11-89
            71-89,48-70
            6-77,6-76
            82-91,84-90
            7-97,47-96
            54-64,54-67
            7-34,16-35
            5-97,4-97
            1-1,3-18
            42-51,42-45
            69-70,69-80
            16-86,16-88
            58-59,58-58
            56-86,57-57
            11-35,10-35
            15-20,37-98
            4-97,96-98
            32-34,32-34
            53-66,12-33
            65-65,3-66
            82-83,9-82
            5-59,2-5
            74-90,43-91
            34-86,35-87
            65-91,5-92
            7-86,8-87
            46-48,47-56
            87-92,8-83
            21-21,22-54
            50-97,50-93
            8-74,8-96
            45-46,46-57
            82-98,34-79
            29-62,29-55
            15-68,16-69
            26-88,37-88
            45-78,46-46
            60-65,60-61
            3-36,36-37
            55-84,56-91
            7-99,7-97
            2-98,1-99
            51-89,63-90
            4-99,3-99
            6-50,6-51
            37-98,62-98
            38-86,38-39
            1-96,1-95
            88-90,78-84
            44-61,4-45
            6-89,89-90
            7-93,19-93
            56-94,93-97
            5-25,13-28
            28-35,29-63
            62-70,63-76
            20-20,21-48
            13-48,45-72
            13-50,50-89
            25-79,25-78
            44-74,33-73
            87-87,62-87
            30-57,54-56
            30-64,20-65
            4-95,5-96
            22-54,13-88
            11-11,8-9
            66-84,67-83
            6-95,7-74
            36-84,23-36
            18-35,18-35
            96-97,42-96
            10-11,11-91
            9-96,95-98
            8-68,8-8
            15-18,13-20
            37-50,8-98
            9-10,10-98
            12-93,13-13
            6-79,7-79
            18-59,18-41
            25-52,41-53
            6-82,6-80
            74-74,6-74
            1-98,1-99
            51-94,93-98
            84-98,5-85
            26-35,23-35
            45-89,34-88
            36-78,37-37
            2-11,17-59
            20-96,20-97
            30-46,13-47
            15-86,15-88
            30-60,12-29
            82-97,12-82
            2-2,3-87
            60-89,59-87
            5-85,6-86
            16-84,15-16
            10-29,18-73
            64-93,65-99
            37-60,37-67
            2-98,1-96
            7-14,8-14
            29-64,29-29
            34-58,33-58
            1-97,2-97
            13-20,23-59
            64-64,65-76
            16-48,6-47
            81-90,81-89
            76-91,23-40
            22-46,21-46
            13-74,74-74
            34-35,18-34
            38-90,37-37
            34-61,36-61
            41-52,42-42
            3-12,3-87
            96-97,43-96
            97-98,4-96
            24-67,40-68
            13-31,4-23
            27-57,26-26
            3-84,84-85
            16-94,93-99
            16-16,17-74
            34-60,2-34
            17-98,17-30
            45-61,34-40
            12-17,11-14
            95-95,3-94
            48-69,11-68
            8-51,50-99
            44-80,44-76
            4-4,5-94
            31-47,30-55
            27-35,36-36
            3-57,3-98
            2-90,3-90
            22-79,22-80
            28-46,27-46
            1-1,3-30
            36-81,36-50
            19-40,19-41
            22-93,11-22
            32-58,31-58
            35-44,24-43
            1-8,1-80
            7-27,9-19
            78-90,14-78
            1-37,36-51
            32-36,30-37
            43-45,30-44
            65-80,66-79
            96-97,43-96
            62-94,61-92
            4-96,96-97
            15-75,14-76
            39-82,38-82
            3-95,3-57
            22-98,32-96
            2-93,3-93
            25-62,62-63
            6-58,57-87
            3-25,2-80
            50-54,51-52
            2-91,1-86
            97-98,38-97
            54-74,3-96
            6-31,31-87
            37-39,38-97
            8-55,8-42
            6-33,7-33
            18-96,81-97
            9-95,94-99
            6-13,5-46
            14-73,34-73
            7-94,7-89
            56-86,57-86
            12-53,11-53
            25-60,24-59
            39-75,28-28
            52-53,52-54
            6-35,12-34
            57-88,38-58
            57-58,7-58
            45-64,4-63
            26-84,3-80
            15-84,15-85
            16-89,17-89
            34-91,33-90
            24-67,94-95
            43-45,44-73
            29-65,66-74
            23-83,22-84
            2-99,1-99
            24-52,25-52
            4-6,5-87
            5-96,1-5
            5-18,24-31
            49-93,55-94
            11-94,43-95
            18-41,17-40
            86-88,85-87
            12-56,16-57
            45-71,45-54
            65-73,62-73
            93-93,61-92
            33-94,34-93
            7-62,14-62
            4-99,1-2
            6-69,1-1
            5-84,83-87
            6-82,93-99
            81-81,1-81
            2-81,1-74
            23-93,22-93
            9-11,3-3
            13-40,12-40
            10-87,9-94
            53-63,54-54
            25-72,45-71
            1-2,5-98
            63-67,23-64
            98-98,63-97
            63-87,50-58
            9-80,10-75
            1-1,3-40
            11-75,76-99
            32-98,33-97
            44-44,34-43
            49-52,33-51
            1-97,2-97
            82-82,82-82
            84-97,4-96
            1-95,13-96
            31-87,4-30
            15-40,5-7
            87-91,40-79
            6-99,5-99
            6-67,55-84
            56-94,83-99
            5-48,49-49
            14-25,24-35
            21-66,22-66
            93-96,94-95
            64-65,18-64
            69-96,68-84
            3-98,2-99
            3-95,2-95
            35-98,94-98
            19-28,29-88
            48-94,49-94
            29-47,29-35
            3-50,1-3
            1-4,1-61
            20-63,19-89
            11-96,11-50
            2-2,5-94
            76-97,76-95
            14-33,47-75
            88-91,12-87
            12-64,12-89
            4-84,3-84
            13-98,6-13
            65-75,64-75
            30-30,19-30
            99-99,39-99
            18-70,18-44
            1-31,1-42
            49-84,83-90
            94-95,54-94
            9-94,95-95
            69-69,68-94
            10-82,10-81
            98-99,63-93
            82-82,75-81
            59-66,25-64
            28-88,88-88
            50-81,81-98
            80-80,27-81
            11-95,10-72
            23-96,22-95
            15-73,14-73
            13-13,3-13
            29-77,29-71
            52-89,78-96
            6-52,25-53
            16-87,15-87
            37-85,63-86
            2-26,11-27
            27-48,28-28
            17-29,9-17
            21-70,21-76
            85-99,85-86
            47-77,48-77
            4-35,36-36
            92-96,58-92
            48-80,47-79
            4-29,82-90
            26-88,27-89
            37-92,36-38
            10-93,11-94
            72-72,17-73
            58-66,60-67
            19-46,19-19
            39-78,30-39
            61-99,39-60
            8-92,8-91
            7-83,5-7
            3-80,1-1
            90-99,5-91
            5-92,92-93
            6-88,6-89
            57-95,19-94
            30-76,31-31
            12-94,93-93
            35-49,36-49
            15-67,16-66
            88-91,63-89
            56-79,55-55
            1-5,4-12
            31-87,30-88
            72-79,73-80
            69-81,70-91
            20-42,43-43
            3-65,15-66
            46-46,45-72
            16-21,15-22
            98-99,34-97
            10-28,48-80
            1-97,3-98
            14-99,15-99
            25-25,25-75
            12-91,12-92
            94-98,11-79
            9-90,9-92
            50-54,49-51
            64-82,64-83
            8-10,9-59
            9-96,96-96
            1-17,23-86
            66-91,66-98
            3-93,2-82
            7-8,8-83
            24-28,25-28
            94-95,7-94
            38-86,38-93
            4-50,32-49
            7-61,61-88
            86-86,9-85
            10-94,7-10
            96-96,10-96
            13-67,40-68
            21-53,22-53
            12-38,13-39
            4-7,21-63
            26-90,91-96
            56-99,56-98
            19-20,18-19
            86-90,7-85
            18-59,18-32
            73-75,69-75
            24-77,25-77
            28-94,25-26
            17-79,79-80
            55-57,54-80
            8-22,8-22
            96-96,7-96
            51-63,53-63
            14-99,15-99
            20-98,20-97
            93-95,9-66
            79-93,78-79
            20-48,20-53
            43-81,44-82
            28-93,29-94
            1-28,28-29
            81-86,56-86
            30-86,89-89
            79-79,78-90
            87-93,27-62
            37-87,37-87
            95-96,4-95
            40-72,38-41
            67-80,48-79
            63-63,19-63
            3-98,16-99
            64-93,37-43
            8-85,16-83
            66-69,50-68
            11-87,12-86
            77-92,5-92
            99-99,96-98
            3-94,2-4
            29-97,28-96
            57-76,65-76
            58-75,58-63
            67-88,66-88
            77-88,57-86
            5-84,84-97
            10-71,8-70
            7-17,3-18
            42-89,43-89
            30-31,3-30
            42-87,41-43
            68-93,67-94
            3-85,3-86
            26-81,27-27
            82-99,74-83
            50-88,51-89
            7-9,11-81
            17-53,25-53
            5-95,5-99
            34-73,74-90
            34-40,35-40
            10-68,46-69
            28-96,95-98
            58-59,5-58
            1-99,2-99
            4-98,5-87
            3-96,2-98
            84-88,83-85
            11-96,10-97
            19-88,2-87
            19-72,23-51
            6-96,2-96
            18-64,14-16
            96-99,3-97
            75-91,13-75
            18-57,32-58
            17-33,17-37
            43-64,63-63
            97-97,14-84
            89-99,9-89
            63-85,64-85
            77-78,47-77
            20-21,1-16
            23-33,23-28
            58-90,59-67
            39-80,20-40
            15-46,3-15
            13-82,81-89
            1-4,9-92
            15-45,3-15
            18-78,12-12
            3-3,2-61
            1-9,1-3
            7-7,6-99
            5-35,4-34
            5-74,6-74
            18-55,17-55
            92-94,11-68
            27-97,27-83
            14-57,57-58
            25-69,26-36
            72-94,72-95
            4-80,4-94
            7-77,7-99
            42-91,42-92
            38-67,22-37
            40-93,40-87
            31-65,5-64
            34-96,96-97
            1-28,27-27
            12-63,13-13
            97-99,71-91
            17-69,16-68
            56-67,56-65
            5-68,6-68
            17-93,23-99
            8-14,7-14
            18-89,18-18
            3-38,39-62
            4-4,5-39
            27-85,84-84
            32-95,96-99
            7-68,17-67
            20-69,19-70
            92-92,32-91
            3-18,4-46
            13-94,13-94
            52-80,52-81
            29-87,3-86
            79-80,35-79
            23-67,47-68
            22-96,24-95
            7-68,4-4
            5-98,3-5
            84-89,84-99
            18-21,1-15
            41-85,40-85
            38-63,60-60
            43-89,43-43
            11-83,10-84
            43-61,11-43
            25-91,26-26
            23-23,22-95
            2-2,1-92
            79-94,9-79
            6-96,34-96
            58-75,57-67
            11-14,14-15
            20-93,19-21
            7-85,7-85
            19-56,20-55
            87-89,6-87
            90-90,2-91
            23-50,22-49
            78-92,22-77
            75-77,74-76
            81-90,81-94
            26-81,81-81
            12-58,41-90
            14-84,13-84
            38-89,39-90
            66-73,65-73
            8-75,8-63
            6-67,3-4
            2-69,3-68
            15-61,15-69
            57-75,57-76
            9-98,98-99
            6-6,20-67
            47-91,46-90
            26-96,26-97
            25-56,24-56
            28-53,27-53
            26-55,25-55
            25-68,26-68
            6-11,11-37
            24-27,25-25
            44-56,8-57
            29-30,29-98
            28-33,27-67
            7-17,7-11
            4-5,25-77
            33-35,34-75
            1-72,73-73
            10-92,92-93
            2-22,83-94
            4-97,96-99
            38-50,18-51
            39-42,41-41
            55-57,55-58
            19-89,36-88
            47-67,48-68
            83-90,83-85
            3-80,46-81
            22-92,48-61
            19-93,33-94
            2-3,1-72
            98-99,30-97
            35-54,54-54
            4-97,5-98
            7-90,8-91
            31-61,4-29
            14-18,15-25
            26-27,26-63
            26-26,9-26
            25-60,60-60
            66-97,63-96
            70-91,6-71
            21-88,22-22
            18-92,14-18
            11-87,4-7
            57-88,58-88
            37-81,3-44
            67-89,55-98
            25-91,24-90
            68-82,67-67
            70-72,43-71
            4-74,74-75
            18-83,9-19
            16-80,81-81
            3-75,2-74
            3-71,11-72
            38-55,7-38
            19-65,20-49
            17-98,16-18
            45-95,24-94
            11-16,15-89
            28-68,29-43
            26-26,25-48
            4-98,3-30
            9-95,95-96
            31-54,31-58
            31-43,30-30
            8-10,10-89
            2-15,1-90
            26-76,46-77
            63-91,62-91
            4-62,19-63
            36-88,36-87
            19-98,19-97
            2-98,98-98
            11-84,11-85
            26-29,6-28
            22-61,26-72
            38-56,38-57
            9-73,1-72
            24-73,23-73
            80-80,9-79
            31-33,32-96
            3-94,4-93
            26-26,25-83
            1-99,1-97
            7-94,7-99
            10-52,3-51
            39-47,42-47
            44-96,43-44
            3-94,2-94
            30-44,29-43
            60-99,60-92
            18-69,69-69
            20-32,1-20
            2-81,13-82
            16-75,9-16
            69-79,80-91
            12-90,12-15
            55-67,56-93
            17-45,3-17
            3-3,2-78
            12-27,28-28
            42-90,59-90
            30-96,31-98
            47-68,63-64
            1-97,2-97
            28-81,22-81
            10-88,1-88
            15-84,15-81
            67-72,68-68
            1-72,1-72
            90-91,86-90
            89-94,79-93
            92-98,15-92
            2-99,1-99
            1-99,99-99
            16-99,17-99
            11-17,17-95
            38-87,39-87
            24-47,28-46
            38-94,38-99
            58-85,59-67
            20-22,21-21
            82-88,59-87
            90-99,89-98
            12-21,20-91
            64-99,61-64
            6-43,5-44
            23-23,24-76
            4-95,3-3
            23-71,24-71
            39-47,38-38
            73-91,92-92
            23-93,87-96
            46-76,27-77
            78-79,65-78
            27-46,26-46
            77-82,83-85
            2-54,54-55
            1-3,6-99
            42-42,22-43
            7-96,8-96
            28-33,28-87
            1-31,1-85
            2-93,3-94
            4-96,2-96
            30-30,29-99
            30-39,30-30
            4-18,34-88
            68-69,68-87
            30-95,30-76
            10-63,10-99
            2-98,98-98
            12-37,11-11
            9-80,9-81
            37-37,38-83
            95-99,7-95
            3-26,60-98
            3-99,4-28
            5-95,6-95
            41-86,42-85
            72-95,39-94
            1-51,1-62
            3-95,95-96
            73-83,74-79
            93-97,93-96
            33-93,32-93
            22-40,21-39
            11-14,18-79
            96-97,58-95
            16-40,40-89
            1-88,2-88
            5-51,5-29
            20-48,31-49
            3-95,95-96
            23-89,23-90
            55-80,56-79
            43-43,42-59
            55-84,54-83
            13-76,76-77
            22-94,9-35
            23-96,68-91
            1-85,60-84
            27-27,11-27
            33-35,33-64
            9-77,10-10
            69-81,90-91
            16-95,16-96
            21-94,21-22
            7-95,3-94
            47-79,1-57
            5-39,5-39
            12-82,13-82
            70-70,63-70
            64-64,26-63
            2-4,4-94
            80-80,79-97
            38-75,37-38
            54-91,92-92
            63-83,63-65
            8-56,8-55
            98-98,27-97
            26-91,28-92
            24-85,20-72
            13-18,30-84
            29-67,29-68
            87-95,8-87
            13-26,11-41
            16-99,17-99
            16-98,17-98
            18-54,18-83
            63-80,64-87
            63-63,58-63
            37-91,37-85
            6-12,4-7
            6-58,30-59
            18-52,53-96
            17-61,17-75
            49-72,71-97
            11-69,11-36
            22-84,22-83
            1-64,1-65
            27-39,38-38
            48-49,49-88
            1-1,3-74
            55-92,55-98
            51-51,8-52
            2-26,1-26
            23-64,64-64
            57-82,57-81
            91-91,26-91
            6-97,41-98
            1-94,1-95
            56-83,16-99
            8-8,10-88
            38-43,6-42
            22-84,2-89
            14-76,72-88
            31-93,30-93
            72-92,73-92
            57-58,21-57
            4-94,6-94
            11-85,86-86
            9-61,8-61
            69-91,69-69
            27-77,77-78
            10-52,10-51
            9-9,8-49
            66-67,65-78
            2-90,2-98
            42-42,41-79
            3-86,3-42
            15-93,25-73
            26-94,27-95
            16-99,15-99
            1-1,3-65
            97-98,4-96
            25-87,26-97
            3-20,20-96
            32-81,32-80
            22-85,22-95
            4-96,97-98
            97-99,62-75
            87-99,46-87
            98-99,44-76
            26-93,26-33
            56-87,34-63
            1-91,95-98
            12-97,11-80
            19-36,19-91
            19-25,25-98
            99-99,7-92
            37-46,38-43
            73-75,73-78
            18-97,97-97
            4-98,4-94
            88-88,25-88
            95-95,4-95
            3-70,9-71
            20-54,19-21
            34-40,24-39
            3-3,2-95
            5-37,4-37
            5-81,5-80
            2-95,9-95
            12-87,13-13
            2-3,2-96
            19-63,19-94
            64-84,35-35
            8-96,5-95
            37-69,38-52
            91-98,12-92
            66-87,66-83
            36-58,20-57
            8-82,82-83
            11-71,13-70
            40-43,39-43
            1-73,1-1
            12-91,12-92
            73-97,41-57
            6-83,7-7
            20-36,19-41
            15-91,14-90
            18-51,13-50
            12-97,97-97
            1-89,89-89
            13-34,12-34
            46-52,46-79
            34-36,34-35
            22-76,76-76
            3-93,4-76
            34-35,22-34
            7-20,20-20
            16-47,2-27
            59-60,2-59
            96-99,37-94
            4-92,4-94
            12-30,8-29
            22-32,22-22
            1-99,2-98
            61-70,53-70
            45-96,46-96
            84-99,2-85
            1-2,1-99
            19-99,20-94
            77-86,86-88
            25-83,3-82
            6-70,5-70
            38-85,85-86
            55-83,55-84
            87-98,86-97
            29-31,29-74
            5-42,5-41
            21-99,21-77
            47-71,46-51
            33-51,50-50
            52-60,5-40
            28-94,29-29
            6-23,11-14
            31-33,32-48
            74-75,44-74
            84-96,84-96
            38-38,37-45
            53-90,92-94
            12-32,2-8
            39-70,38-70
            93-96,17-93
            43-60,33-37
            4-22,3-95
            1-89,2-90
            27-76,26-77
            34-71,57-71
            49-62,20-62
            48-97,2-95
            11-72,2-5
            72-72,72-92
            22-65,64-78
            24-96,24-25
            38-93,32-94
            70-71,59-70
            38-76,38-76
            31-50,30-50
            22-97,21-69
            22-79,24-80
            69-88,88-88
            47-48,46-87
            27-29,28-42
            24-24,25-71
            11-94,20-95
            1-10,29-85
            32-52,32-86
            15-72,73-93
            15-28,15-47
            14-64,15-64
            88-88,25-89
            80-80,15-80
            3-58,58-59
            19-96,95-99
            39-74,40-87
            64-71,71-72
            49-80,36-80
            61-79,49-78
            """;
    public static void main(String[] args) {
        int sum = INPUT.lines()
                .mapToInt(line -> {
                    String[] assignments = line.split(",");
                    return doubleAssignments(assignments);
                })
                .sum();
        System.out.println(sum);

        sum = INPUT.lines()
                .mapToInt(line -> {
                    String[] assignments = line.split(",");
                    return partialDoubleAssignments(assignments);
                })
                .sum();
        System.out.println(sum);

    }

    private static int doubleAssignments(String[] assignments) {
        int[] assignmentExtraction = extractAssignment(assignments);
        return assignmentExtraction[0] >= assignmentExtraction[2] && assignmentExtraction[1] <= assignmentExtraction[3]
                || assignmentExtraction[2] >= assignmentExtraction[0] && assignmentExtraction[3] <= assignmentExtraction[1]
                ? 1 : 0;
    }

    private static int partialDoubleAssignments(String[] assignments) {
        int[] assignmentExtraction = extractAssignment(assignments);
        return IntStream.range(assignmentExtraction[0], assignmentExtraction[1] + 1)
                .anyMatch(i -> i >= assignmentExtraction[2] && i <= assignmentExtraction[3])
                ? 1 : 0;
    }

    private static int[] extractAssignment (String[] assignments){
        String[] assignment1 = assignments[0].split("-");
        String[] assignment2 = assignments[1].split("-");
        return new int[] {
                Integer.parseInt(assignment1[0]),
                Integer.parseInt(assignment1[1]),
                Integer.parseInt(assignment2[0]),
                Integer.parseInt(assignment2[1])
        };
    }
}
