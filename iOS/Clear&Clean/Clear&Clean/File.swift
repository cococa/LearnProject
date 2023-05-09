//
//  File.swift
//  Clear&Clean
//
//  Created by sj on 2023/5/6.
//

import Foundation


class File {
    var fileSize: UInt64
    var humanFileSize: String
    
    init(fileSize: UInt64, humanFileSize: String){
            self.humanFileSize = humanFileSize
            self.fileSize = fileSize
    }
    
    
}

