//
// Created by Alexandre Gherschon on 26/06/2018.
// Copyright (c) 2018 galex.co.il. All rights reserved.
//

import Foundation
import UIKit

class ChordView: UIView {

    override func draw(_ rect: CGRect) {
        super.draw(rect)

        if let context = UIGraphicsGetCurrentContext() {
            context.setStrokeColor(UIColor.gray.cgColor)
            context.setLineWidth(1)
            context.move(to: CGPoint(x: 0, y: bounds.height))
            context.addLine(to: CGPoint(x: bounds.width, y: bounds.height))
            context.strokePath()
        }
    }
    
    func test() {
        
    }
}
