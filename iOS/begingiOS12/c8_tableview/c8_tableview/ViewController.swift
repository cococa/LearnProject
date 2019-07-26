//
//  ViewController.swift
//  c8_tableview
//
//  Created by jun shen on 2019/3/28.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit

class ViewController: UIViewController ,UITableViewDataSource,UITableViewDelegate{

    var  names :Array<String> = []
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        for index in 0...100{
            names .append("\(index)")
        }
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    return names.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
          let cell =  tableView.dequeueReusableCell(withIdentifier: "datacell", for: indexPath)
          cell.textLabel?.text = names[indexPath.row]
        
//        cell.imageView?.image = UIImage(named: "                    restaurant")
          return cell
    }
    
    
    

}

