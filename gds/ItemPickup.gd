extends Item
class_name ItemPickup

##var pickingUp = false

func interact(ply)->void:
	##if !pickingUp:
		##var tween = Tween.new()
		##add_child(tween)
		##tween.connect("tween_all_completed", self, "_on_tween_all_completed")
		
		##tween.interpolate_property(self.get_child(0), "translation", 
			##self.get_child(0).transform, ply.get_node("UpperCollider/Camera").transform, .2, Tween.TRANS_LINEAR)
		##tween.start()
		##pickingUp = true
	pass

##func _on_tween_all_completed():
	##queue_free()
